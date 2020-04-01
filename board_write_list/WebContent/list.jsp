<%@page import="com.yks.board_Encoding.ChangeEncoding"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.yks.board_write_list.DBClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DBClass.connectMySQL();
	ResultSet rs = DBClass.dataSelectAll();
	
//	rs.next();
//	System.out.print(rs.getString(1));
//	System.out.print(rs.getString(2));

	
%>

<html>
	<head>
	<title>게시판 리스트</title>
	</head>
	
	<body>
		<h1>글 목록</h1>
		<table border="1">
		<tr> <th>글 번호</th> <th>제목</th> <th>글쓴이</th> <th>조회수</th> </tr>
		<%	
		int no = 0;
		String writer = null;
		String title = null;
		String contents = null;
		int hit = 0;

		while(rs.next()){
			no = rs.getInt(1);
			writer = ChangeEncoding.toUnicode(rs.getString(2));
			title = ChangeEncoding.toUnicode(rs.getString(3));
			contents = ChangeEncoding.toUnicode(rs.getString(4));
			hit = rs.getInt(5);
			%>
			
			<tr>
				<td><%= no %></td>
				
				<td><a href=hit.jsp?no=<%= no %> > <%= title %> </a></td>
				<td><%= writer %></td>
				<td><%= hit %></td>
			</tr>
				<% } %>
		</table>
		<br />
		<input type = "button" value = "글쓰기" onclick = "location.href='write_form.jsp'" />
	</body>
</html>