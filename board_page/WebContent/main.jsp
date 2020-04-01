<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.yks.DB.DBClass" %>
<%
	String status="SUCCESS";
// 	status=DBClass.insertData();
	if(status.equals("SUCCESS")){
		response.sendRedirect("list.jsp?pNo=1");
	}
%>