<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String name = request.getParameter("name"); %>
	포함되는 페이지 includeSub1.jsp입니다. <p>
	<b><%= name %>님 어서오세요!</b>
	<hr>
</body>
</html>