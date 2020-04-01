<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	Connection con = null;
	Statement stmt = null;
	
	try{
		
	Class.forName("oracle.jdbc.driver.OracleDriver");
	out.println("드라이버 로딩 성공");
	
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	con = DriverManager.getConnection(url, "yks", "1234");
	out.println("DB접속 성공 <br>");
	} catch (ClassNotFoundException ce){
		System.out.println("해당 클래스를 찾지 못했습니다." + ce.getMessage());
	} catch (SQLException se) {
		System.out.println(se.getMessage());
	} finally{
		//db접속 해제
		try{
			if (stmt != null){
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
%>