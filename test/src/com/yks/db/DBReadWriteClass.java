package com.yks.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBReadWriteClass {

	private static Connection conn = null;
	
	public DBReadWriteClass() {	
	}
	
	public static void connectMySQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("����̹� �ε� ����");
			
			String url = "jdbc:mysql://localhost:3306/lms_db";
			conn = DriverManager.getConnection(url, "root", "Fhrhkd1490!");
			System.out.println("DB ���� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver err" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB ���� ����" + e.getMessage());
		}
	}
	
	public static ResultSet dataSelectAll()	{
		String querySelect = "select * from stu_table";
		ResultSet rs = null;
		
		try {
			Statement stmt = conn.createStatement();
			rs  = stmt.executeQuery(querySelect);
			
		} catch (SQLException e) {
			System.out.println("data sellect err " + e.getMessage());
		}
		
		return rs;
	}

}
