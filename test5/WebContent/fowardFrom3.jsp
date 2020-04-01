<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포워딩 하는 페이지 (forwardFrom3.jsp)</h1>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String color = request.getParameter("color") + ".jsp";
	%>
	
	<jsp:forward page="<%= color %>" />
</body>
</html>