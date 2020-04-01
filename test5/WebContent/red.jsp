<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포워딩 되는 페이지 - red.jsp</h1>
	
	<%
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		
	%>
	<b><%= name %></b>님의 좋아하는 색은 "<%= color %>"이고 생명을 상징하는 색입니다. <br /><br />
	<img src="img/<%= color + ".jpg" %>">
</body>
</html>