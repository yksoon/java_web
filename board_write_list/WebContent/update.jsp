<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.yks.board_write_list.DBClass" %>
	
	<% 
//	String writer = request.getParameter("no");
	int no = Integer.parseInt(request.getParameter("no"));
	String w = request.getParameter("writer");
	String t = request.getParameter("title");
	String c = request.getParameter("contents");
	
	String status = DBClass.updateContents(no, w, t, c);
	
	out.print(status);
	if(status.equals("SUCCESS")){
		response.sendRedirect("update_form.jsp?no=");
	}
	%>