package com.yks.DB;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yks.changeEncoding.ChangeEncoding;

public class DBClass {

	public DBClass() {
	}
	
	private static Connection conn = null;
	public static void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/board_db";
			conn = DriverManager.getConnection(url, "root", "Fhrhkd1490!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER ERR : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("CONNECT ERR : " + e.getMessage());
		}
		
	}
	
//	public static String insertData() {
//		connectDB();
//		String status = null;
//		
//		String queryInsert = "insert into page_table (title) values (?)";
//		PreparedStatement pstmt = null;
//		String title = "테스트 ";
//		try {
//			pstmt = conn.prepareStatement(queryInsert);
//			int n=0;
//			for (int i = 0; i < 95; i++){
//				pstmt.setString(1, ChangeEncoding.toLatin(title + i));
//				n=pstmt.executeUpdate();
//			}
//			status = (n>0) ? "SUCCESS" : "FAIL";
//		} catch (SQLException e) {
//			System.out.println("INSERT ERR : " + e.getMessage());
//		}
//		idxReset();
//		return status;
//	}
	
	public static int recordCount() {
		connectDB();
		// 데이터가 없을 경우
		String query = "select count(*) from page_table";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("QUERY ERR : " + e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("CLOSE ERR : " + e.getMessage());
			}
		}
		return 0;
	}
	
	public static ResultSet selectPage(int idx) {
		connectDB();
		// 페이지에 대한 시작 index 구하기
		int pageNo = idx-1;
		pageNo = pageNo*10;	// pageNo : query 내부의 ?에 전달할 시작 index
		
		String selectQuery = "select * from page_table order by no desc limit ?, 10";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, pageNo);
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			System.out.println("SELECT ERR : " + e.getMessage());
		}
		return rs;
	}
	
	public static String insertData() {
		connectDB();
		String status = null;
		
		String queryInsert = "insert into page_table (title, mkdate, ipaddr) values (?, now(), ?)";
		PreparedStatement pstmt = null;
		String ip = getIP();
		
		try {
			pstmt = conn.prepareStatement(queryInsert);
			int n=0;
			for (int i = 0; i< FileClass.fileRead().size(); i++){
				pstmt.setString(1, ChangeEncoding.toLatin(FileClass.fileRead().get(i)));
				pstmt.setString(2, ip);
				n=pstmt.executeUpdate();
			}
			status = (n>0) ? "SUCCESS" : "FAIL";
		} catch (SQLException e) {
			System.out.println("INSERT ERR : " + e.getMessage());
		}
		idxReset();
		return status;
	}
	
	public static void idxReset(){
		connectDB();
		String query1 = "alter table page_table auto_increment=1";
		String query2 = "set @count = 0";
		String query3 = "update page_table set no = @count:=@count+1";
		
		try {
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate(query1);
			stmt.executeUpdate(query2);
			stmt.executeUpdate(query3);
			
		} catch (SQLException e) {
			System.out.println("IDX RESET ERR : " + e.getMessage());
		}	
	}
	
	private static String getIP() {
		String ip = null;
		try {
			ip=InetAddress.getLocalHost().getHostAddress();
			System.out.println("IP ADDR : " + ip);
		} catch (UnknownHostException e) {
			System.out.println("IP Address ERR : " + e.getMessage());
		}
		return ip;
	}
}
