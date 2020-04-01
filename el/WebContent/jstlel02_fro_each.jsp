<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	response.setContentType("text/html;");
	String[] abc = {"빨강", "파랑", "노랑"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="t" value="hello" />
	<c:out value="${t }" />
	<br />
	
	<h3>pageScope</h3>
	<c:forEach items="${pageScope }" var="h">
		<c:out value="${h }" />
	</c:forEach>
	
	<h3>colors</h3>
	<c:set var="color" value="<%= abc %>" />
	<c:forEach items="${color }" var="clr">
		<c:out value="${clr }" />
		<br />
	</c:forEach>
	
	<h3>colors Object (추출된 카운트, 추출된 인덱스)</h3>
	<c:set var="color" value="<%= abc %>" />
	<c:forEach items="${color }" varStatus="i">	<!-- varstatus 배열의 반복 상태 -->
		<c:out value="${i.count }" />. <c:out value="${color[i.index] }" />	<!-- i.count 는 i++ 즉 count값 , i.index는 i의 인덱스 -->
		<br />
	</c:forEach>
</body>
</html>