<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String contentPage = request.getParameter("CONTENTPAGE");
String contentPage2 = request.getParameter("CONTENTPAGE2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버 쇼핑</title>
</head>
<body>

	<table width="400" border="1" cellpadding="0" cellspacing="0" align="left">
		<tr height="80">
		<td><jsp:include page="top.jsp" flush="false" /></td>
		</tr>
		
		<tr height="80">
		<td><jsp:include page="mid.jsp" flush="false" /></td>
		</tr>
		
		<tr height="600">
		<td><jsp:include page="<%= contentPage %>" flush="false" /></td>
		</tr>	
	</table>
	<table width="400" border="1" cellpadding="0" cellspacing="0" align="right">
		<tr height="80">
		<td><jsp:include page="top2.jsp" flush="false" /></td>
		</tr>
		
		<tr height="80">
		<td><jsp:include page="mid2.jsp" flush="false" /></td>
		</tr>
		
		<tr height="600">
		<td><jsp:include page="<%= contentPage2 %>" flush="false" /></td>
		</tr>	
	</table>
</body>
</html>