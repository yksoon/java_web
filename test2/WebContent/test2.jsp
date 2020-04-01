<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>오늘의 메뉴</h3>
	- 짜장면<br />
	- 볶음밥<br />
	- 짬뽕<br /><br />
	<%
// 		out.flush();
		RequestDispatcher rd = request.getRequestDispatcher("now.jsp");
		rd.include(request, response);
	%>
</body>
</html>