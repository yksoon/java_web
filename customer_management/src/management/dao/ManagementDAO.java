package management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import management.dto.ManagementDTO;

public class ManagementDAO {
	
	DataSource ds;
	ResultSet rs;
	
	public ManagementDAO() {	// 기본생성자
		try {
			// InitialContext ctx = new InitialContext(); 이것도 가능
			// 이유 : InitialContext implements Context
			Context ctx = new InitialContext();
			
			// lookup("java:comp/env/찾고자하는 JNDI이름")
			// 찾고자하는 JNDI이름 : => Context.xml <Resource type="~~">
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/orcl");
			System.out.println("ds : " + ds);
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 고객 리스트 조회
	 * @return
	 */
	public ArrayList<ManagementDTO> customerList() {
		ArrayList<ManagementDTO> customerList = new ArrayList<ManagementDTO>();
		
		
		try {
			String sql = "SELECT * FROM customer_tab ORDER BY customerNo desc";
			Connection con = ds.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				ManagementDTO data = new ManagementDTO();
				
				data.setCustomerNo(rs.getInt("customerNo"));
				data.setName(rs.getString("name"));
				data.setPhone(rs.getString("phone"));
				data.setEmail(rs.getString("email"));
				
				customerList.add(data);
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}	// list() END
	
	/**
	 * 시술리스트 조회
	 * @return
	 */
	public ArrayList<ManagementDTO> serviceList() {
		ArrayList<ManagementDTO> serviceList = new ArrayList<ManagementDTO>();
		
		
		try {
			String sql = "SELECT * FROM service_tab ORDER BY serviceNo desc";
			Connection con = ds.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				ManagementDTO data = new ManagementDTO();
				
				data.setContent(rs.getString("content"));
				data.setPrice(rs.getInt("price"));
				data.setNailNo(rs.getInt("serviceNo"));
				
				serviceList.add(data);
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serviceList;
	}	// list() END
	
	/**
	 * 시술 예약 리스트 조회
	 * @return
	 */
	public ArrayList<ManagementDTO> mainList() {
		ArrayList<ManagementDTO> mainList = new ArrayList<ManagementDTO>();
		
		
		try {
			String sql = "SELECT * FROM main_tab ORDER BY day desc";
			Connection con = ds.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				ManagementDTO data = new ManagementDTO();
				
				data.setNailNo(rs.getInt("serviceNo"));
				data.setCustomerNo(rs.getInt("customerNo"));
				data.setDay(rs.getString("day"));
				data.setName(rs.getString("name"));
				data.setContent(rs.getString("content"));
				data.setPrice(rs.getInt("price"));
				
				mainList.add(data);
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mainList;
	}	// list() END
	
	/**
	 * 고객 정보 추가 메서드
	 * @param name
	 * @param phone
	 * @param email
	 */
	public void addCustomer(String name, String phone, String email) {
		try{
			
			String sql = "INSERT INTO customer_tab (customerNo, name, phone, email) " + "VALUES (customer_seq.NEXTVAL,?,?,?)";
			
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, name);
			stmt.setString(2, phone);
			stmt.setString(3, email);
			stmt.executeUpdate();		// == stmt.executeUpdate(sql);
			
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 시술 추가 메서드
	 * @param content
	 * @param price
	 */
	public void addService(String content, int price) {
		try{
			
			String sql = "INSERT INTO service_tab (serviceNo, content, price) " + "VALUES (service_seq.NEXTVAL,?,?)";
			
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, content);
			stmt.setInt(2, price);
			stmt.executeUpdate();		// == stmt.executeUpdate(sql);
			
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 예약 전 입력한 값을 따로 뽑아오는 메서드
	 * @param name
	 * @param content
	 * @return
	 */
	public ManagementDTO selectAddMain(String name, String content) {
		ManagementDTO data = new ManagementDTO();
		
		try{
			String selectQuery1 = "SELECT name, phone, email FROM customer_tab WHERE customerNo=?";
			String selectQuery2 = "SELECT content, price FROM service_tab WHERE serviceNo=?";
			
			Connection con = ds.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(selectQuery1);
			if (name != null) {
				stmt.setInt(1, Integer.parseInt(name));
				rs = stmt.executeQuery();
				rs.next();
				data.setName(rs.getString("name"));
				data.setPhone(rs.getString("phone"));
				data.setEmail(rs.getString("email"));
			}
			if (content != null) {
				stmt = null;
				stmt = con.prepareStatement(selectQuery2);
				stmt.setInt(1, Integer.parseInt(content));
				rs = stmt.executeQuery();
				rs.next();
				data.setContent(rs.getString("content"));
				data.setPrice(rs.getInt("price"));
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
		return data;
	}
	
	public ManagementDTO scheduleRe(String customerNo) {
		ManagementDTO data = new ManagementDTO();
		
		try{
			String selectQuery = "SELECT day, name, content FROM main_tab WHERE customerNo=?";
			
			Connection con = ds.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(selectQuery);
				stmt.setInt(1, Integer.parseInt(customerNo));
				rs = stmt.executeQuery();
				rs.next();
				
				data.setDay(rs.getString("day"));
				data.setName(rs.getString("name"));
				data.setContent(rs.getString("content"));
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.getMessage();
		}
		return data;
	}
	
	/**
	 * 예약 추가 메서드
	 * @param rs
	 * @param day
	 */
	public void addMain(String name, String content, String day) {
		ManagementDTO temp = selectAddMain(name, content);
		
		try{
			String insertQuery = "INSERT INTO main_tab (day, name, content, price, customerNo, serviceNo) ";
			String valuesQuery = "VALUES (TO_DATE(?,'YYYY-MM-DD'), ?, ?, ?, ?, ?)";
			String sql = insertQuery + valuesQuery;
			
			
			
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, day);
			stmt.setString(2, temp.getName());
			stmt.setString(3, temp.getContent());
			stmt.setInt(4, temp.getPrice());
			stmt.setInt(5, Integer.parseInt(name));
			stmt.setInt(6, Integer.parseInt(content));
			
			stmt.executeUpdate();		// == stmt.executeUpdate(sql);
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 날짜랑 이름 비교하여 검색됨 (main_tab에서)
	 * @param day
	 * @param name
	 * @return
	 */
	private ResultSet selectAddSale(String day, String name) {
		try{
			String selectQuery = "SELECT day, price FROM main_tab ";
			String whereQuery = "WHERE day=? AND name=?";
			
			String sql = selectQuery + whereQuery;
			
			Connection con = ds.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, day);
			stmt.setString(2, name);
			rs = stmt.executeQuery();
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * sale_tab 추가 메서드
	 * @param day
	 * @param name
	 */
	public void addSale(String day, String name) {
		
		try{
			String insertQuery = "INSERT INTO sale_tab (day, price) ";
			String valuesQuery = "VALUES (TO_DATE(?,'YYYY-MM-DD'), ?)";
			String sql = insertQuery + valuesQuery;
			
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			rs = selectAddSale(day, name);
			rs.next();
			stmt.setString(1, rs.getString("day"));
			stmt.setInt(2, rs.getInt("price"));
			
			stmt.executeUpdate();		// == stmt.executeUpdate(sql);
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 고객 삭제 메서드
	 * @param managementDTO
	 */
	public void deleteCustomer (int customerNo){
		try{
			String sql = "DELETE FROM customer_tab WHERE customerNo = ?";
			
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, customerNo);
			stmt.executeUpdate();		// == stmt.executeUpdate(sql);
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 시술 리스트 삭제 메서드
	 * @param managementDTO
	 */
	public void deleteService (int serviceNo){
		try{
			String sql = "DELETE FROM service_tab WHERE serviceNo = ?";
			
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, serviceNo);
			stmt.executeUpdate();		// == stmt.executeUpdate(sql);
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMain (String day){
		try{
			String sql = "DELETE FROM main_tab WHERE day = TO_DATE(?,'YYYY-MM-DD')";
			
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, day);
			stmt.executeUpdate();		// == stmt.executeUpdate(sql);
			
			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ManagementDTO> customerLists() {
		ArrayList<ManagementDTO> customerLists = new ArrayList<ManagementDTO>();
		
		try{
			
			String sql1 = "SELECT customerNo, name FROM customer_tab ";
			
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql1);
			
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				ManagementDTO data = new ManagementDTO();
				
				data.setCustomerNo(rs.getInt("customerNo"));
				data.setName(rs.getString("name"));

				customerLists.add(data);
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return customerLists;
	}
	
	public ArrayList<ManagementDTO> serviceLists() {
		ArrayList<ManagementDTO> serviceLists = new ArrayList<ManagementDTO>();
		
		try{
			String sql2 = "SELECT serviceNo, content FROM service_tab";
			
			Connection con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql2);
			
			rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				ManagementDTO data = new ManagementDTO();
				
				data.setNailNo(rs.getInt("serviceNo"));
				data.setContent(rs.getString("content"));
				
				serviceLists.add(data);
			}
			
			
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return serviceLists;
	}
	
	public void customerUpdate(String name, String phone, String email, int customerNo) {
		try {
			String sql1 = "UPDATE customer_tab SET name=?, phone=?, email=? WHERE customerNo=?";
			String sql2 = "UPDATE main_tab SET name=? WHERE customerNo=?";
			
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, email);
			pstmt.setInt(4, customerNo);
			
			pstmt.executeUpdate();
			
			pstmt = null;
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, name);
			pstmt.setInt(2, customerNo);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void serviceUpdate(String content, String price, int serviceNo) {
		try {
			String sql1 = "UPDATE service_tab SET content=?, price=? WHERE serviceNo=?";
			String sql2 = "UPDATE main_tab SET content=?, price=? WHERE serviceNo=?";
			
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, content);
			pstmt.setString(2, price);
			pstmt.setInt(3, serviceNo);
			
			pstmt.executeUpdate();
			
			pstmt = null;
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, content);
			pstmt.setString(2, price);
			pstmt.setInt(3, serviceNo);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void scheduleUpdate(String day, String name, String content, int customerNo, int nailNo) {
		try {
			System.out.println(day);
			System.out.println(name);
			System.out.println(content);
			System.out.println(customerNo);
			System.out.println(nailNo);
			String sql = "UPDATE main_tab SET day=TO_DATE(?,'YYYY-MM-DD'), name=?, content=?, customerNo=?, serviceNo=? WHERE customerNo=?";
			
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, day);
			pstmt.setString(2, name);
			pstmt.setString(3, content);
			pstmt.setInt(4, customerNo);
			pstmt.setInt(5, nailNo);
			pstmt.setInt(6, customerNo);
			
			pstmt.executeUpdate();
			
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
