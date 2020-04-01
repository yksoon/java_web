<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포워딩 되는 페이지 (a.jsp)</h1>
	
	<%
		String name = request.getParameter("name");
		String bloodType = request.getParameter("bloodType");
	%>
	
	<b> <%= name %></b>님의 혈액형은
	<b> <%= bloodType %></b>형이고
	<p> 성실하고 신중하며 완벽주의자 입니다.

</body>
</html>