<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= request.getParameter("NUM1") %>
	<%= request.getParameter("NUM2") %>
	<%= request.getAttribute("ADD") %>

</body>
</html>