<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String date = request.getParameter("writeday");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>확인</title>
</head>
<body>
	<table border="0">
		<tr>
			<td align="right">자기소개서상의 모든 기재사항은 사실임을 확인합니다.</td>
		</tr>
		<tr>
			<td align="right"><%= date %></td>
		</tr>
		<tr>
			<td align="right">작성자 <%= name %>(인)</td>
		</tr>
		<tr>
			<td align="right"><input type="button" name="BACK" value="뒤로" onclick="location.href='personal'" />
			<td align="right"><input type="button" value="확인" onclick="location.href='main.jsp'" />
		</tr>
	</table>
</body>
</html>