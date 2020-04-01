<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포워딩 하는 페이지 : forwardFrom2.jsp</h1>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String bloodType = request.getParameter("bloodType") + ".jsp";
		// String bloodType = "a.jsp";
	%>
	
	<jsp:forward page="<%= bloodType %>" />
	<!-- forward 액션태그 때문에 이 파일의 내용은 화면 출력 안된다. -->

</body>
</html>