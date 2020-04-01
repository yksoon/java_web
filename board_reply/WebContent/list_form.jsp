<%@page import="com.yks.board_reply.ChangeEncoding"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.yks.board_reply.DBClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
DBClass.connectDB();
ResultSet rs = DBClass.selectAll();
%>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
	<h1>목록</h1>
	<form>
		<table border="1">
			<tr> <th>번호</th> <th>작성자</th> <th>내용</th> </tr>
			<%
			int no = 0;
			String writer = null;
			String contents = null;
			String s = null;
			
			while (rs.next()){
				no = rs.getInt(1);
				writer = ChangeEncoding.toUnicode(rs.getString(2));
					s = "";
				if(rs.getInt(3) != 0){
					for(int i = 0; i < rs.getInt(3); i++){
						s = s + "ㄴ";
					} 
				} else {
					s = " ";
				}
				
				if(rs.getString(6) != null){
					contents = ChangeEncoding.toUnicode(rs.getString(6));
					if (contents.length() >= 20){
						contents = contents.substring(0, 20) + "...";
					}
				} else {
					contents = " ";
				}
				
			%>
			<tr>
				<td><%= no %></td>
				<td><%= writer %></td>
				<td><%= s + contents %></td>
			</tr>
			<% } %>
		</table>
		<br /><br />
		<input type="button" name="newWrite" value="글쓰기" onclick="location.href='write_form.jsp'" />
	</form>
</body>
</html>