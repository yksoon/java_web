package com.yks.board_reply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClass {

	public DBClass() {
	}
	private static Connection conn = null;
	public static void connectDB() {
		String url = "jdbc:mysql://localhost:3306/board_db";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "Fhrhkd1490!");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver ERR : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB Connect ERR : " + e.getMessage());
		}
	}	// connectDB() END
	
	public static ResultSet selectAll (){
		String selectQuery = "select * from board order by uid desc";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			System.out.println("select Query ERR : " + e.getMessage());
		}
		return rs;
	}	// selectAll () END
	
	private static ResultSet uidCountSelect() {
		String selectQuery = "select count(uid) from board";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			System.out.println("QUERY ERR : " + e.getMessage());
		}
		
		return rs;
	}	// uidCountSelect() END
	
	// 새글 작성 메서드
	public static String newInsertData(String n, String c) {
		String insertQuery = "insert into board (name, depth, uid, group_, contents) values (?, 0, ?, ?, ?)";
		String status = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			rs = uidCountSelect();
			rs2 = selectAll();
			int i = 0;
			while (rs.next()){
				i = rs.getInt(1);
			}
			int ii = 0;;
			if (rs2.next()){
				ii = rs2.getInt(1) + 1;
			} else {
				ii = 1;
			}
			pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, ChangeEncoding.toLatin(n));
			pstmt.setInt(2, i + 1);
			pstmt.setInt(3, ii);
			pstmt.setString(4, ChangeEncoding.toLatin(c));
			int nn = pstmt.executeUpdate();
			status = (nn > 0) ? "SUCCESS" : "FAIL";
		} catch (SQLException e) {
			System.out.println("QUERY ERR : " + e.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("Close ERR : " + e.getMessage());
			}
		}
		idxReset();
		return status;
	}	// newInsertData(String n) END
	
	// 인덱스 초기화 메서드
	private static void idxReset(){
		connectDB();
		String query1 = "alter table board auto_increment=1";
		String query2 = "set @count = 0";
		String query3 = "update board set idx = @count:=@count+1";
		
		try {
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate(query1);
			stmt.executeUpdate(query2);
			stmt.executeUpdate(query3);
			
		} catch (SQLException e) {
			System.out.println("IDX RESET ERR : " + e.getMessage());
		}	
	}	// idxReset() END
	
	private static ResultSet selectOne(int i) {
		String selectQuery = "select * from board where idx = ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("QUERY ERR : " + e.getMessage());
		}
		return rs;
	}
	
//	private static ResultSet upperUid (int i) {
//		String selectQuery = "select uid from board where uid > i order by uid";
//		ResultSet rs = null;
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = conn.prepareStatement(selectQuery);
//			pstmt.setInt(1, i);
//			rs = pstmt.executeQuery();
//		} catch (SQLException e) {
//			System.out.println("QUERY ERR" + e.getMessage());
//		}
//		return rs;
//	}
	
	private static void updateUid (int i) {
		String updateQuery = "update board set uid = (uid +1) where uid > ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setInt(1, i);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("UPDATE QUERY ERR : " + e.getMessage());
		}
	}
	
	private static void updateUid2 (String s) {
		String updateQuery = "update board set uid = (uid +1) where name = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, s);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("UPDATE QUERY ERR : " + e.getMessage());
		}
	}
	
	public static String replyInsertData(String n, int i){
		ResultSet rs = selectOne(i);
		
		String insertQuery = "insert into board (name, depth, uid, group_) values (?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		String status = null;
		try {
			rs.next();
			int num=rs.getInt(4);
			String s = rs.getString(2);
			
			pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, n);
			pstmt.setInt(2, rs.getInt(3) + 1);
			pstmt.setInt(3, rs.getInt(4));
			pstmt.setInt(4, rs.getInt(5));
			int nn = pstmt.executeUpdate();
			status = (nn > 0) ? "SUCCESS" : "FAIL";
			
			updateUid(num);
			updateUid2(s);
		} catch (SQLException e) {
			System.out.println("INSERT Query ERR : " + e.getMessage());
		}
		idxReset();
		return status;
	}

}
