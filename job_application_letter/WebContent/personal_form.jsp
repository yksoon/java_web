<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%
	Date date = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy년MM월dd일");
	String strdate = simpleDate.format(date);
	
	Calendar cal = Calendar.getInstance();
	
	String name2 = request.getParameter("name");
	
	if(name2==null){
		name2="";
	}else{
		name2=request.getParameter("name");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이력 및 경력사항</title>
</head>
<body>
	<form action="personal" method="post">
		<table border="0">
			<tr>
				<th align="center" width="693px;">
					<h1>이 력 및 경 력 기 술 서</h1>
				</th>
			</tr>
		</table>
		<table border="1">
			
			<tr>
				<td rowspan="2" align="center">성<br />명</td> 
				<td><input type="text" name="name" placeholder="(한글)" required="required" value="<%= name2 %>" /></td>
				<td align="center">희망분야</td><td align="center"><input type="text" value="프로그램 개발 엔지니어" readonly="readonly" /></td>
				<td align="center">작성일자</td><td align="center"><input type="text" name="writeday" value="<%= cal.get(Calendar.YEAR) %>년<%= cal.get(Calendar.MONTH)+1 %>월<%= cal.get(Calendar.DATE) %>일" /></td>
			</tr>
			<tr>
				<td align="center"><input type="text" name="engname" placeholder="(영문)" required="required"/></td>
				<td align="center">희망직무</td><td align="center"><input type="text" value="프로그램 개발 " readonly="readonly" /></td>
				<td align="center">추천인</td><td align="center">-</td>
			</tr>
			<tr><br /></tr>
			<tr>
				<td align="center">생년<br />월일</td>
				<td colspan="4" align="center"><input type="date" name="birthday" placeholder="19xx.xx.xx(양력)" size="65px;" required="required"/> </td>
				<td rowspan="4" align="center">사진첨부 필수</td>
			</tr>
			<tr>
				<td align="center">현주소</td>
				<td colspan="4" align="center"><input type="text" name="address" placeholder="(필수)" size="65px;" required="required" /></td>
			</tr>
			<tr>
				<td align="center">E-mail</td>
				<td colspan="4">
				<input type="text" name="email" placeholder="(필수)" size="10px;" required="required" />
				@
				<select name="email2">
					<option>선택</option>
					<option>naver.com</option>
					<option>gmail.com</option>
					<option>hanmail.com</option>
				</select>
				</td>
			</tr>
			<tr>
				<td align="center">연락처</td>
				<td colspan="4" align="center"><input type="text" name="phone" placeholder="(필수)" size="65px;" required="required" /></td>
			</tr>
			<tr>
				<td align="right" colspan="6"><input type="submit" value="확인" /></td>
			</tr>
		</table>
		
	</form>
</body>
</html>