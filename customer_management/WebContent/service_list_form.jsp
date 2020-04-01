<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, management.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시술 리스트</title>
</head>
<body>
	<h1>시술 리스트</h1>
		
	<table border="1">
		<tr>
			<th>시술명</th><th>금액</th>
		</tr>
		
		<%
			    ArrayList<ManagementDTO> servicelists = (ArrayList<ManagementDTO>) request.getAttribute("servicelist");
			
			    if(servicelists != null){
			    	for (ManagementDTO servicelist : servicelists) {
			    		
						String content = servicelist.getContent();
						int price = servicelist.getPrice();
						int nailNo = servicelist.getNailNo();
			%>
			
			<tr>
				<td><%= content %></td>
				<td><%= price %></td>
				<td><input type="button" name="modify" value="수정" onclick="location.href='serviceRe.do?nailNo=<%= nailNo %>'"></td>
				<td><input type="button" name="delete" value="삭제" onclick="location.href='serviceDe.do?nailNo=<%= nailNo %>'"></td>
			</tr>
			<%
					}
				}
			%>
		<tr>
			<td align="left" colspan="2">
				<input type="button" value="추가" onclick="location.href='serviceAddForm.do'" />
				<input type="button" value="뒤로" onclick="location.href='main.do'" />
			</td>
		</tr>
	
	</table>
	
</body>
</html>