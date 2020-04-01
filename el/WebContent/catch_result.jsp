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
	<c:catch var = "myError">
		<% int x = 10/0; %>
	</c:catch>
	
	<c:if test="${myError != null }">
		${myError.message }
	</c:if>
</body>
</html>