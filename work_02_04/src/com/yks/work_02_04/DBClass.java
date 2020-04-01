package com.yks.work_02_04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClass {

	public DBClass() {
	}
	
	private static Connection conn = null;
	
	public static void connectDB() {;
		try {
			String url = "jdbc:mysql://localhost:3306/device_db";
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver load success");
			conn = DriverManager.getConnection(url, "root", "Fhrhkd1490!");
			System.out.println("DB connect success");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver load err : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB connect err : " + e.getMessage());
		}
	}
	
	public static ResultSet selectAll() {
		String selectQuery = "select * from device_table";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(selectQuery);
		} catch (SQLException e) {
			System.out.println("Query err : " + e.getMessage());
		}
		return rs;
	}
	
	public static String insertNew(String n, String t, int c, int m, double i, double o){
		String insertQuery = "insert into device_table ";
		return null;
	}
	
	
	
}	// Class END
