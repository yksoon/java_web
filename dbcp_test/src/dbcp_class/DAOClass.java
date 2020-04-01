package dbcp_class;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOClass {
	
	public DAOClass() {
	}
	
	private void connectDB(){
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			Connection conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println("ERR : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB ERR : " + e.getMessage());
		}
		
		System.out.print("DBCP 접속 성공");
	}
}
