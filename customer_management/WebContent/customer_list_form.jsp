<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, management.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>고객 리스트</title>
</head>
<body>
	<form action="">
	<table border="1">
		<caption>고객 리스트</caption>
		<tr><th>이름</th> <th>연락처</th></tr>
		<%
			    ArrayList customerlist = (ArrayList) request.getAttribute("customerlist");
			
			    if(customerlist != null){
			        Iterator iter = customerlist.iterator();
			        while(iter.hasNext() == true){
			        	
			            ManagementDTO data = (ManagementDTO)iter.next();
			            
						String name = data.getName();
						String phone = data.getPhone();
						int customerNo = data.getCustomerNo();
			%>
			
			<tr>
				<td><%= name %></td>
				<td><%= phone %></td>
				<td><input type="button" value="수정" onclick="location.href='custormerRe.do?customerNo=<%= customerNo %>'"></td>
				<td><input type="button" value="삭제" onclick="location.href='custormerDe.do?customerNo=<%= customerNo %>'"></td>
			</tr>
			<%
					}
				}
			%>
	</table><br />
	<input type="button" value="추가" onclick="location.href='custormerAddForm.do'" /> <input type="button" value="뒤로" onclick="location.href='main.do'" /><br /><br />
	<select name="searchType">
		<option value="name">이름</option>
		<option value="phoneNum">연락처</option>
	</select> <input type="search" name="searchText" size="35" placeholder="연락처 검색 시 : 000-0000-0000 형식으로 입력" /> <input type="submit" value="검색" /><br />
	</form>
</body>
</html>