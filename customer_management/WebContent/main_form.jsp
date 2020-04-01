<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, management.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>예약 현황</title>
</head>
<body>
	<form action="">
	<table border="1">
		<caption>예약 현황</caption>
		<tr><th colspan="6" style="text-align:right;"><input type="button" value="고객리스트" onclick="location.href='customerlist.do'" /> <input type="button" value="시술리스트" onclick="location.href='servicelist.do'" /> <input type="button" value="일정추가" onclick="location.href='schedulelist.do'" /></th></tr>
		<tr><th>날짜</th> <th>이름</th> <th>내용</th> <th>금액</th></tr>
		<%
			    ArrayList mainlist = (ArrayList) request.getAttribute("mainlist");
			
			    if(mainlist != null){
			        Iterator iter = mainlist.iterator();
			        while(iter.hasNext() == true){
			        	
			            ManagementDTO data = (ManagementDTO)iter.next();
			            
			            int customerNo = data.getCustomerNo();
			            int nailNo = data.getNailNo();
			            String day = data.getDay();
						String name = data.getName();
						String content = data.getContent();
						int price = data.getPrice();
			%>
			
			<tr>
				<td><%= day.substring(0, 11) %></td>
				<td><%= name %></td>
				<td><%= content %></td>
				<td><%= price %></td>
				<td><input type="button" value="시술 완료" onclick="" /></td>
				<td><input type="button" value="예약 취소" onclick="location.href='scheduleDe.do?day=<%= day %>'" /></td>
			</tr>
			<%
					}
				}
			%>
	</table><br />
	</form>
	<form action="#"> <!-- search.do -->
	<select name="searchType">
		<option value="day">날짜</option>
		<option value="name">이름</option>
	</select> <input type="search" name="searchText" size="35" required="required" placeholder="날짜 검색 시 : 0000-00-00 형식으로 입력" /> <input type="submit" value="검색" /><br />
	<input type="button" value="메인" onclick="location.href='main.do'" /> <input type="button" value="매출" onclick="sales_form.jsp" />
	</form>
</body>
</html>