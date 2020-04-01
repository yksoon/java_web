<%@page import="com.yks.visitor_book.ChangeEncodeClass"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.yks.visitor_book.DBClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String p = DBClass.deleteData(request.getParameter("pw2"), Integer.parseInt(request.getParameter("no")));
	
	if(p.equals("SUCCESS")) {
		response.sendRedirect("visit.jsp");
	} else { %>
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="UTF-8">
		<title>방명록 상세보기</title>
		</head>
		<body>
			<%
			DBClass.connectVisitorDB();
			ResultSet rs = DBClass.selectAll();
			
			String writer = null;
			String contents = null;
			String pw = null;
			int no2 = 0;
			while (rs.next()){
				int no = Integer.parseInt(request.getParameter("no"));
				
				if(no == rs.getInt(1)) {
					writer = ChangeEncodeClass.toUnicode(rs.getString(3));
					contents = ChangeEncodeClass.toUnicode(rs.getString(2));
					pw = ChangeEncodeClass.toUnicode(rs.getString(4));
					no2 = no;
				}
			
			}
			%>
			<h1>비밀번호 재확인</h1>
				<form action="detail.jsp" method="get">
				비밀번호
				<br />
				<input type="text" size="10" name="pw2" required="required" />
				<br />
				<input type="button" value="글 목록" onclick="location.href='visit.jsp'" />
				<input type="submit" value="확인" />
				
				<input type="hidden" readonly="readonly" name="pw3" value=<%= pw %> required="required" />
				<input type="hidden" readonly="readonly" name="no" value=<%= no2 %> required="required" />
				</form>
		</body>
		</html>
		
		
	<% } %>

