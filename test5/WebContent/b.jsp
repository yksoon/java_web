<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포워딩 되는 페이지 (b.jsp)</h1>
	
	<%
		String name = request.getParameter("name");
		String bloodType = request.getParameter("bloodType");
	%>
	
	<b> <%= name %></b>님의 혈액형은
	<b> <%= bloodType %></b>형이고
	<p> 규격을 싫어하는 자유인 입니다.


</body>
</html>