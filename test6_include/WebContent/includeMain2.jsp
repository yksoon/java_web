<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String siteName1 = request.getParameter("siteName1");
	%>
	
	<hr>
	<jsp:include page="includeSub2.jsp">
		<jsp:param value="<%= siteName1 %>" name="siteName"/>
	</jsp:include>
	includeMain2.jsp 페이지의 나머지 내용입니다.
	<p>
</body>
</html>