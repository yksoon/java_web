<%@page import="com.yks.board_Encoding.ChangeEncoding"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.yks.board_write_list.DBClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
<head>
<meta charset="UTF-8">
<title>글 내용</title>
</head>
<body>
	<%
	DBClass.connectMySQL();
	ResultSet rs = DBClass.dataSelectAll();
	
	String writer = null;
	String title = null;
	String contents = null;
	
	while (rs.next()){
		int no = Integer.parseInt(request.getParameter("no"));
		if(no == rs.getInt(1)){
			writer = ChangeEncoding.toUnicode(rs.getString(2));
			title = ChangeEncoding.toUnicode(rs.getString(3));
			contents = ChangeEncoding.toUnicode(rs.getString(4));
		}
	}
	
	%>
	<h1>글 수정하기</h1>
	작성자 <input type = "text" size = "20" value="<%= writer %>" />
	<br /><br />
	
	제목    <input type = "text" size = "60" value="<%= title %>" />
	<br /><br />
	
	내용    <textarea rows="10" cols="60"><%= contents %></textarea>
	<br /><br />
	
	<input type="button" value="완료" ><a href=update.jsp?no=></a>

</body>
</html>