package jobClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOClass {
	
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection conn = null;

	public DAOClass() {
	}
	
	/**
	 * DB 접속 메서드
	 */
	private Connection connectDB() {
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			this.conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println("ERR : " + e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DB접속 성공");
		
		return conn;
	}
	
	/**
	 * insert 쿼리
	 * @param mc
	 */
	public void insertPersonal(ModelClass mc){
		connectDB();
		
		String first = "INSERT INTO PERSON_TABLE (name, engname, writeday, birthday, address, email, email2, phone) ";
		String last = "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		String query = first+last;
		
		try {
			this.pstmt = this.conn.prepareStatement(query);
			
			this.pstmt.setString(1, mc.getName());
			this.pstmt.setString(2, mc.getEngname());
			this.pstmt.setString(3, mc.getWriteday());
			this.pstmt.setString(4, mc.getBirthday());
			this.pstmt.setString(5, mc.getAddress());
			this.pstmt.setString(6, mc.getEmail());
			this.pstmt.setString(7, mc.getEmail2());
			this.pstmt.setString(8, mc.getPhone());
			
			this.pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Query ERR : " + e.getMessage());
		} finally {
			close(null, pstmt, conn);
		}
	}
	
	/**
	 * 자원 해제 메서드
	 * @param rs
	 * @param pstmt
	 * @param conn
	 */
	public void close (ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
