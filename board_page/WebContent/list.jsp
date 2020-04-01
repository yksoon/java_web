<%@page import="com.yks.changeEncoding.ChangeEncoding"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.yks.DB.DBClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	int total = DBClass.recordCount();
	int totalPageNum = 0;
	if(total>0){
		double d = total/(10*1.0);
		d=Math.ceil(d);
		totalPageNum = (int)d;
	}
	int pageNo = 0;
	pageNo = Integer.parseInt(request.getParameter("pNo"));
	ResultSet rs = DBClass.selectPage(pageNo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<!-- 여기에는 테이블 오는 위치 -->
	<h1>게시판</h1>
	<table border="1">
	<tr> <th>번호</th> <th>제목</th> <th>날짜</th> <th>접속주소</th> </tr>
	<%
	int no = 0;
	String title = null;
	String mkdate = null;
	String ipaddr = null;
	
	while(rs.next()){
		no = rs.getInt(1);
		title = ChangeEncoding.toUnicode(rs.getString(2));
		mkdate = rs.getString(3);
		ipaddr = rs.getString(4);
	%>
	<tr>
		<td><%= no %></td>
		<td><%= title %></td>
		<td><%= mkdate %></td>
		<td><%= ipaddr %></td>
	</tr>
	<% } %>
	</table>
	
	<!-- 하단은 현재 페이지와 페이지 번호들을 출력 -->
	현재 페이지 번호 : <%= pageNo %>
	 <br /><br />
	<% for(int i =1; i < (totalPageNum + 1); i++){ %>
		<a href = "list.jsp?pNo=<%= i %>">
			<%= i %>
		</a>
		&nbsp;
		<% } %>	
		
</body>
</html>