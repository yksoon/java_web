<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매출</title>
</head>
<body>
	<h1>매출 확인</h1>
	<form action="#" method="post">
		
		<table border="1">
			<tr>
				<th colspan="2">연도</th><th colspan="2">월</th><th colspan="2">일</th>
			</tr>
			<tr>
				<td><input type="text" name="year" /></td><td>년</td>
				<td><input type="text" name="month" /></td><td>월</td>
				<td><input type="text" name="day" /></td><td>일</td>
				<td><input type="submit" value="검색" />
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="2">연도</th><th colspan="2">월</th><th colspan="2">일</th>
			</tr>
			<tr>
				<td colspan="6" align="right">총 계 : </td><td>000</td>
			</tr>
			<tr>
				<td><input type="text" name="year" /></td><td>년</td>
				<td><input type="text" name="month" /></td><td>월</td>
				<td><input type="text" name="day" /></td><td>일</td>
			</tr>
		</table>
	</form>
</body>
</html>