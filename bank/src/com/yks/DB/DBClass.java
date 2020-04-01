package com.yks.DB;

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
	
	public static void DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DRIVER LOAD SUCCESS");
			
			String url = "jdbc:mysql://localhost:3306/bank_db";
			conn = DriverManager.getConnection(url, "root", "Fhrhkd1490!");
			System.out.println("DB CONNECT SUCCESS");
			
		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER LOAD ERR : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB CONNECT ERR : " + e.getMessage());
		}
	}	// DBConnect() END
	
	public static String createAccount(String account, String name, int money) {
		String status = null;
		
		String insertQuery = "insert into bank_table(account, name, money) value (?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(insertQuery);
			pstmt.setString(1, account);
			pstmt.setString(2, ChangeEncoding.toLatin(name));
			pstmt.setInt(3, money);
			
			int n = pstmt.executeUpdate();
			status = (n > 0) ? "SUCCESS" : "FAIL";
		} catch (SQLException e) {
			System.out.println("QUERY ERR : " + e.getMessage());
		}
		return status;
	}	// createAccount() END
	
	public static ResultSet selectAll(){
		String selectQuery = "select * from bank_table";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
			
		} catch (SQLException e) {
			System.out.println("SELECT QUERY ERR : " + e.getMessage());
		}
		return rs;
	}
	
	private static ResultSet selectOne(String account) {
		String selectQuery = "select money from bank_table where account = ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("SELECT ONE ERR : " + e.getMessage());
		}
		return rs;
	}
	
	public static String updateSave(String account, int money) {
		String updateQuery = "update bank_table set money = ? where account = ?";
		ResultSet rs = selectOne(account);
		
		String status = null;
		PreparedStatement pstmt = null;
		
		try {
			int i = 0;
			while (rs.next()){
				i = rs.getInt(1);
			}
			int ii = i + money;
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(2, account);
			pstmt.setInt(1, ii);
			
			int n = pstmt.executeUpdate();
			status = (n > 0) ? "SUCCESS" : "FAIL";
		} catch (SQLException e) {
			System.out.println("UPDATE QUERY ERR : " + e.getMessage());
		}
		return null;
	}
	
	public static String updateWithdraw(String account, int money) {
		String updateQuery = "update bank_table set money = ? where account = ?";
		ResultSet rs = selectOne(account);
		
		String status = null;
		PreparedStatement pstmt = null;
		
		try {
			int i = 0;
			while (rs.next()){
				i = rs.getInt(1);
			}
			int ii = i - money;
			if (i > money){
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(2, account);
			pstmt.setInt(1, ii);
			
			int n = pstmt.executeUpdate();
			
				if (n > 0) {
					status = "SUCCESS";
				}
			} else if (i < money){
				status = "FAIL";
			}
			
		} catch (SQLException e) {
			System.out.println("UPDATE QUERY ERR : " + e.getMessage());
		}
		return status;
	}

}
