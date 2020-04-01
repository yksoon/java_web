package com.yks.board_write_list;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yks.board_Encoding.ChangeEncoding;

public class DBClass {

	private static Connection conn = null;
	
	public DBClass() {	
	}
	
	public static void connectMySQL() {		// DB연결 메서드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			String url = "jdbc:mysql://localhost:3306/board_db";
			conn = DriverManager.getConnection(url, "root", "Fhrhkd1490!");
			System.out.println("DB 접속 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver err" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 접속 에러" + e.getMessage());
		}
	}
	
	public static ResultSet dataSelectAll()	{	// 전체 데이터 조회 메서드
		String querySelect = "select idx, writer, title, contents, hit from board_table order by idx desc";
		ResultSet rs = null;
		
		try {
			Statement stmt = conn.createStatement();
			rs  = stmt.executeQuery(querySelect);
			
		} catch (SQLException e) {
			System.out.println("data sellect err " + e.getMessage());
		}
		
		return rs;
	}	// dataSelectAll() END
	
	public static ResultSet dataSelectContents()	{	// 전체 데이터 조회 메서드
		String querySelect = "select idx, contents from board_table order by idx desc";
		ResultSet rs = null;
		
		try {
			Statement stmt = conn.createStatement();
			rs  = stmt.executeQuery(querySelect);
			
		} catch (SQLException e) {
			System.out.println("data sellect err " + e.getMessage());
		}
		
		return rs;
	}
	
									// write.jsp 로부터 전달 받음
	public static String dataInsert (String w, String t, String c) {
		connectMySQL();
		String status = null;	// 글 저장 성공 여부 (FAIL / SUCCESS)
		
		String queryInsert = "insert into board_table (writer, title, contents) values (?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(queryInsert);
			pstmt.setString(1, ChangeEncoding.toLatin(w));
			pstmt.setString(2, ChangeEncoding.toLatin(t));
			pstmt.setString(3, ChangeEncoding.toLatin(c));
			int n = pstmt.executeUpdate();
			status = (n>0) ? "SUCCESS" : "FAIL";
		} catch (SQLException e) {
			System.out.println("INS ERR : " + e.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("CLOSE ERR : " + e.getMessage());
			}
		}
		return status;
	}	// dataInsert() END
	
	public static String hitUp(int no) {
		connectMySQL();
		
		String queryHit = "update board_table set hit=hit+1 where idx=?";
		PreparedStatement pstmt = null;
		String status = null;		//조회수 증가 성공 여부
		
		try {
			pstmt = conn.prepareStatement(queryHit);
			pstmt.setInt(1, no);
			int n = pstmt.executeUpdate();
			status = (n>0) ? "SUCCESS" : "FAIL";
		} catch (SQLException e) {
			System.out.println("INS ERR : " + e.getMessage());
		} finally {	// 위의 try / catch 종료 후 자원 해제
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("CLOSE ERR : " + e.getMessage());
			}
		}
		return status;
	}
	
	public static String updateContents(int no, String w, String t, String c) {
		connectMySQL();
		
		String queryUpdate = "update board_table set writer = ?, title = ?, contents = ? where idx = ?";
		PreparedStatement pstmt = null;
		String status = null;		//수정 성공 여부
		
		try {
			pstmt = conn.prepareStatement(queryUpdate);
			pstmt.setString(1, w);
			pstmt.setString(2, t);
			pstmt.setString(3, c);
			pstmt.setInt(4, no);
			int n = pstmt.executeUpdate();
			status = (n>0) ? "SUCCESS" : "FAIL";
		} catch (SQLException e) {
			System.out.println("INS ERR : " + e.getMessage());
		} finally {	// 위의 try / catch 종료 후 자원 해제
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("CLOSE ERR : " + e.getMessage());
			}
		}
		return status;
	}

}