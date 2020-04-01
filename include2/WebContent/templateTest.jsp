<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contentPage = request.getParameter("CONTENTPAGE");
// 	String contentPage = "content.jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width = "600" border="1" cellpadding="0" cellspacing="0" align="center">
	
		<tr height="80">
			<td colspan="2">	<!-- 상단 영역 -->
			<jsp:include page="top.jsp" flush="false" />
			</td>
		</tr>
		
		<tr height="300">
			<td width="150" valign="top"> <!-- 좌측영역 -->
			<jsp:include page="left.jsp" flush="false" />
			</td>
		
			<td width="350" valign="top"> <!-- 본문내용 -->
			<jsp:include page="<%= contentPage %>" flush="false" />
			</td>
		</tr>
		
		<tr height="80">
			<td colspan="2">	<!-- 하단 영역 -->
			<jsp:include page="bottom.jsp" flush="false" />
			</td>
		</tr>	
		
		</table>
	

</body>
</html>