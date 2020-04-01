<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h3>약관</h3>
	--------------------------------------------- <br />
	1. 회원 정보는 웹 사이트의 운영을 위해서만 사용됩니다. <br />
	2. 웹 사이트의 정상 운영을 방해하는 회원은 탈퇴 처리합니다. <br />
	--------------------------------------------- <br />
	<form action="Subscribe" method="post">
		위의 약관에 동의 하십니까?
			<input type="radio" name="AGREE" value="yes" />동의함
			<input type="radio" name="AGREE" value="no" />동의 하지 않음 <br /><br />
			<input type="submit" value="확인" />
	</form>

</body>
</html>