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
		String appPath = application.getContextPath();
		String filePath = application.getRealPath("/sub1/intro.html");
	%>
	웹 애플리케이션의 URL 경로명 : <%= appPath %> <br />
	/sub1/intro.html의 파일 경로명 : <%= filePath %> <br />
</body>
</html>