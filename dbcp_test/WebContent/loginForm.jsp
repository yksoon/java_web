<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	
	<form action="#" method="post">
		아이디 <input type="text" name="id" required="required" /> <br />
		암   호 <input type="password" name="pw" required="required" /> <br />
		
		<input type="submit" value="로그인" />
		<input type="reset" value="취소" />
		<input type="button" value="회원가입" onclick="location.href='joinForm.jsp'" />
	</form>
</body>
</html>