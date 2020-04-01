<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
response.sendRedirect("http://localhost:9000/spring_simple_board/list.do");
%>

<%--
초기 화면인 list.jsp로 바로 이동

web.xml에
	<welcome-file-list>
		<welcome-file>초기 로딩 페이지</welcome-file>
	</welcome-file-list>
같이 설정하면
애플리케이션 명으로 요청이 들어 왔을때 자동 호출
--%>