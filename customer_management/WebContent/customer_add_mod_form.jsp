<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, management.dto.*" %>
<%
	String name = "";
	String phone = "";
	String email = "";
	String customerNo = "";

	ManagementDTO data = (ManagementDTO) request.getAttribute("data");
	if (data != null) {
		name = data.getName();
		phone = data.getPhone();
		email = data.getEmail();
		customerNo = request.getParameter("customerNo");
	}
	
	String act = "custormerAdd.do";
	String val = "추가";
	if (!name.equals("")) {
		act = "custormerUp.do";
		val = "수정";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>고객 상세사항</title>
</head>
<body>
	<form action="<%= act %>">
	<table border="1">
		<caption>고객 상세사항 </caption>
		<tr><td>이름</td> <td><input type="text" name="name" value="<%= name %>" required="required" /></td></tr>
		<tr><td>연락처</td> <td><input type="tel" name="phone" value="<%= phone %>" placeholder="000-0000-0000" required="required" /></td></tr>
		<tr><td>이메일</td> <td><input type="email" name="email" value="<%= email %>" placeholder="example@naver.com" /></td></tr>
	</table><br />
	<input type="hidden" name="customerNo" value="<%= customerNo %>" />
	<input type="submit" value="<%= val %>" /> <input type="reset" value="취소" onclick="location.href='customerlist.do'" /><br /><br />
	</form>
</body>
</html>