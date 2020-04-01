<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>반복</h3>
	
	<h4>&lt;c:forEach></h4>
	<c:forEach var="one" begin="1" end="10">
		<c:out value="${one }"></c:out>
	</c:forEach>
	
	<p><b>header</b></p>
	<c:forEach var="h" items="${header }">
		<c:out value="${h.key }:${h.value }" /> <br />
	</c:forEach>
</body>
</html>