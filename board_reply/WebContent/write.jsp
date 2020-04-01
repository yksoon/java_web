<%@page import="com.yks.board_reply.DBClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String writer = request.getParameter("writer");
	String contents = request.getParameter("contents");
	
	String status = null;
	status = DBClass.newInsertData(writer, contents);
	if (status.equals("SUCCESS")){
		status = "글 저장 성공";
	}else{
		status = "글 저장 실패";
	}
%>
<html>
	<head>
		<title>결과</title>
	</head>
	
	<body>
		<h1><%= status %></h1>
		<br /><br />
		<input type="button" value="목록으로 돌아가기" onclick="location.href='list_form.jsp'" />
	</body>

</html>