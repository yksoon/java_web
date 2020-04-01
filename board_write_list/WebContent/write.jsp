<%@page import="com.yks.board_write_list.DBClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String writer = request.getParameter("writer");
String title = request.getParameter("title");
String contents = request.getParameter("contents");

String status = null;

status = DBClass.dataInsert(writer, title, contents);

out.print(status);


%>
