<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>포워딩 되는 페이지 : forwardTo1.jsp</h2>
	
	<% request.setCharacterEncoding("UTF-8"); %>
	<%
		String id = request.getParameter("id");
		// forward로 최종적으로 받는 파일에 request를 해도 된다
		String password = request.getParameter("password");
	%>	<b>
	
	<%= id %></b>님의 <p> 패스워드는 <b><%= password %></b> 입니다.

</body>
</html>