<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.yks.el.InfoModel" %>
<%
	InfoModel info = new InfoModel();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="info" value="<%= info %>"></c:set>
	<c:set target="${info}" property="name" value="테스트"></c:set>
	<c:set target="${info}" property="age" value="24"></c:set>
	<c:remove var="info"/>
	
	회원이름 : ${info.name } <br />
	나이 : ${info.age } <br />
</body>
</html>