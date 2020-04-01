<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="result2">
		이름 <br />
		<input type="text" name="name" placeholder="한글만 입력" required="required" pattern="[가-힣]{1,10}" /> <br /><br />
		연락처<br />
		<input type="text" name="phone" placeholder="010-0000-0000" required="required" pattern="[0-9]{3}-[0-9]{3,4}-[0-9]{4}" /> <br /><br />
		이메일 <br />
		<input type="email" name="email" placeholder="ex)ooo@ooo.com" required="required" /><br /><br />
		<input type="submit" value="다음" />
		<input type="button" value="이전" onclick="location.href='join.html'" />
		
	</form>

</body>
</html>