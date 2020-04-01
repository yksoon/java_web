<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>결과</h3>
	id : <%= request.getAttribute("rID") %> <br />
	pw : <%= request.getAttribute("rPW") %> <br />
	이름 : <%= request.getParameter("name") %> <br />
	전화번호 : <%= request.getParameter("phone") %> <br />
	이메일 : <%= request.getParameter("email") %>

</body>
</html>