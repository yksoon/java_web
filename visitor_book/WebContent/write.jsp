<%@page import="com.yks.visitor_book.DBClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
    String writer = request.getParameter("writer");
    String contents = request.getParameter("contents");
    String pw = request.getParameter("pw");
    
    String status = null;
    status = DBClass.insertData(pw, writer, contents);
    out.print(status);
    
    if (status.equals("SUCCESS")){
    	response.sendRedirect("visit.jsp");
    }
    
%>