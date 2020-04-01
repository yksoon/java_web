<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>계좌 리스트</title>
</head>

<body>
	<h1>메인 메뉴</h1>
	<table border="1">
		<tr> 
			<th><input type="button" value="계좌 생성" onclick="location.href='create_form.jsp'" /></th> 
			<th><input type="button" value="계좌 목록" onclick="location.href='list_form.jsp'" /></th> 
			<th><input type="button" value="예금" onclick="location.href='save_form.jsp'" /></th> 
			<th><input type="button" value="출금" onclick="location.href='withdraw_form.jsp'" /></th> 
		</tr>
	</table>	
</body>
</html>