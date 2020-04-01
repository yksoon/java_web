<%@page import="java.sql.ResultSet"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.yks.work_02_04.DBClass" %>
<!DOCTYPE html>

<%
DBClass.connectDB();
ResultSet rs = DBClass.selectAll();
int idx = 0;
String name = null;
String type = null;
int cpu = 0;
int memory = 0;
double incoming = 0;
double outgoing = 0;
String connection1 = null;
String connection2 = null;
String connection3 = null;
%>

<html>
<head>
<meta charset="UTF-8">
<title>기기 목록 화면</title>
</head>
<body>
	<h3>기기 목록 화면</h3>
	<form action="#" method="get">
	<table border="1">
		<tr>
			<th></th>
			<th>번호</th>
			<th>이름</th>
			<th>종류</th>
			<th>CPU 사용</th>
			<th>메모리사용</th>
			<th>요청 트래픽</th>
			<th>응답 트래픽</th>
			<th>연결기기1</th>
			<th>연결기기2</th>
			<th>연결기기3</th>
		</tr>
		<%
		while(rs.next()){
			idx = rs.getInt(1);
			name = rs.getString(2);
			type = rs.getString(3);
			cpu = rs.getInt(4);
			memory = rs.getInt(5);
			incoming = rs.getDouble(6);
			outgoing = rs.getDouble(7);
			connection1 = rs.getString(8);
			connection2 = rs.getString(9);
			connection3 = rs.getString(10);
		}
		%>
		<tr>
			<td><input type="checkbox" name="check"></td>
			<td><%= idx %></td>
			<td><%= name %></td>
			<td><%= type %></td>
			<td><%= cpu %></td>
			<td><%= memory %></td>
			<td><%= incoming %></td>
			<td><%= outgoing %></td>
			<td><%= connection1 %></td>
			<td><%= connection2 %></td>
			<td><%= connection3 %></td>
		</tr>
	</table>
	<br />
	검색 <input type="text" name="search" />
	&nbsp;
	<input type="button" name="add" value="추가" onclick="location.href='add.html'" />
	&nbsp;
	<input type="submit" value="삭제" />
	</form>
</body>
</html>