<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, management.dto.*" %>
<%
	String dayDefault = "";
	String nameDefault = "";
	String contDefault = "";
	String customerNDefault = "";

	ManagementDTO data = (ManagementDTO) request.getAttribute("data");
	if (data != null) {
		dayDefault = data.getDay();
		nameDefault = data.getName();
		contDefault = data.getContent();
		customerNDefault = request.getParameter("customerNo");
	}
	
	String act = "scheduleAdd.do";
	if (!contDefault.equals("")) {
		act = "scheduleUp.do";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 추가 및 수정</title>
</head>
<body>
	<h1>시술 일정 추가 및 수정</h1>
	<form action="<%= act %>"> <!-- scheduleAdd.do -->
		<table border="1">
			<tr>
				<th>시술 날짜</th><td><input type="date" name="day" required="required" /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<select name="name" required="required" size="1">
					<option><%= nameDefault %></option>
			<%
			    ArrayList<ManagementDTO> customerlists = (ArrayList<ManagementDTO>) request.getAttribute("customerlist");
			
			    if(customerlists != null){
			    	for (ManagementDTO customerlist : customerlists) {
		    			int customerNo = customerlist.getCustomerNo();
						String name = customerlist.getName();
			%>
				<option value="<%= customerNo %>"><%= name %></option>
			<%
					}
				}
			%>
					</select>
				</td>
			</tr>
			
			<tr>
				<th>시술내용</th>
				<td>
					<select name="content" required="required" size="1">
					<option><%= contDefault %></option>
			<%
			ArrayList<ManagementDTO> servicelists = (ArrayList<ManagementDTO>) request.getAttribute("servicelist");
			
			    if(servicelists != null){
			    	for (ManagementDTO servicelist : servicelists) {
			    			int nailNo = servicelist.getNailNo();
							String content = servicelist.getContent();
			%>
				<option value="<%= nailNo %>"><%= content %></option>
			<%
					}
				}
			%>
					</select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="right">
					<input type="hidden" name="customerNo" value="<%= customerNDefault %>" />
					<input type="submit" value="확인">
					<input type="reset" value="취소" onclick="location.href='main.do'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>