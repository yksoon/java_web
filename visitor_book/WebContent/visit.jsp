<%@page import="com.yks.visitor_book.ChangeEncodeClass"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.yks.visitor_book.DBClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	DBClass.connectVisitorDB();
	ResultSet rs = DBClass.selectAll(); 
%>
<html>
<head>
	<title>방명록</title>
</head>
	
<body>
	<h1>방명록 리스트</h1>
	<table border="1">
	<tr> <th>번호</th> <th>내용</th> <th>작성자</th> </tr>
	<%
	int no = 0;
	String contents = null;
	String writer = null;
	
	while(rs.next()){
	no = rs.getInt(1);
	writer = ChangeEncodeClass.toUnicode(rs.getString(3));
	contents = ChangeEncodeClass.toUnicode(rs.getString(2));
	if (contents.length() >= 20){
		contents = contents.substring(0, 20) + "...";
	}
	%>
	<tr>
		<td><%= no %></td>
		<td><a href=detail_form.jsp?no=<%= no %>><%= contents %></a></td>
		<td><%= writer %></td>
	</tr>
	<% } %>
	
	</table>
	<br />
	<input type="button" value="방명록 쓰기" onclick="location.href='write_form.jsp'" />

</body>
</html>