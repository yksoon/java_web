<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.sendRedirect("./board/boardListServlet");	
	// BoardListServlet GET 방식으로 요청
	// 따라서 BoardListServlet의 doGet() 메서드 자동 호출
	// 이때 현재 페이지의 request, response 내장 객체가 전달 됨
	// doGet(request, response) 와 같은  형식
	/****** response.sendRedirect() 메서드는 항상 GET 방식으로 호출 ******/
%>