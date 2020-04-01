package com.yks.visitor_book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClass {
	
	private static Connection conn = null;

	public DBClass() {
	}
	
	public static void connectVisitorDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/visitor_db";
			conn = DriverManager.getConnection(url, "root", "Fhrhkd1490!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER ERR : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB connect ERR : " + e.getMessage());
		}
	}
	public static void idxReset(){
		connectVisitorDB();
		String query1 = "alter table visitor_table auto_increment=1";
		String query2 = "set @count = 0";
		String query3 = "update visitor_table set no = @count:=@count+1";
		
		try {
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate(query1);
			stmt.executeUpdate(query2);
			stmt.executeUpdate(query3);
			
		} catch (SQLException e) {
			System.out.println("IDX RESET ERR : " + e.getMessage());
		}	
	}
	
	public static ResultSet selectAll (){	// 데이터 전체 조회 메서드
		String querySelect = "select no, contents, writer, pw from visitor_table order by no desc";
		ResultSet rs = null;
		
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(querySelect);
			
		} catch (SQLException e) {
			System.out.println("SELECT ERR : " + e.getMessage());
		}
		return rs;
	}	// selectAll ()
	
	public static String insertData (String p, String w, String c){	// 방명록 작성 insert 메서드
		connectVisitorDB();
		String status = null;
		
		String insertQuery = "insert into visitor_table (pw, writer, contents) value (?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, ChangeEncodeClass.toLatin(p));
			pstmt.setString(2, ChangeEncodeClass.toLatin(w));
			pstmt.setString(3, ChangeEncodeClass.toLatin(c));
			int n = pstmt.executeUpdate();
			status = (n>0) ? "SUCCESS" : "FAIL";	
		} catch (SQLException e) {
			System.out.println("INSERT ERR + " + e.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("CLOSE ERR : " + e.getMessage());
			}
		}
		idxReset();
		return status;
	}	// insertData() END
	
	public static String deleteData(String p, int n) {
		connectVisitorDB();
		String status = null;
		//  "delete from visitor_table where pw = ? AND no=?"
		String deleteQuery = "delete from visitor_table where pw = ? AND no = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setString(1, p);
			pstmt.setInt(2, n);
			
			int nn = pstmt.executeUpdate();
			status = (nn > 0) ? "SUCCESS" : "FAIL";
		} catch (SQLException e) {
			System.out.println("DELETE ERR : " + e.getMessage());
		}
		idxReset();
		return status;
	}

	
}
