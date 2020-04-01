<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, management.dto.*" %>
<%
	String content = "";
	int price = 0;
	String serviceNo = "";

	ManagementDTO data = (ManagementDTO) request.getAttribute("data");
	if (data != null) {
		content = data.getContent();
		price = data.getPrice();
		serviceNo = request.getParameter("nailNo");
	}
	
	String act = "serviceAdd.do";
	if (!content.equals("")) {
		act = "serviceUp.do";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시술 추가, 수정</title>
</head>
<body>
	<h1>시술 추가 및 수정</h1>
	
	<form action="<%= act %>" method="get">
		<table border="1">
			<tr>
				<th>시술명</th><td><input type="text" name="content" value="<%= content %>" required="required" /></td>
			</tr>
			<tr>
				<th>금액</th><td><input type="text" name="price" value="<%= price %>" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="확인" />
					<input type="reset" value="취소" onclick="location.href='servicelist.do'" />
				</td>
			</tr>
	
		</table>
	</form>
</body>
</html>