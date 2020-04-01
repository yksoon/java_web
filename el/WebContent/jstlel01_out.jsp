<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>header 라는 객체가 갖고 있는 값들을 불러서 보여준다.
		request.getHeader() 로 가져올수 있는것
	</h1>
	<h3>header</h3>
	<c:forEach items="${header }" var="h">
		<c:out value="${h }" /> <br />
	</c:forEach>
	
	<h3>header.cookie</h3>
	<c:out value="${header.cookie }" />
	<br />
	
	<h3>또는 header["cookie"]</h3>
	<c:out value='${header["cookie"]}' />
</body>
</html>