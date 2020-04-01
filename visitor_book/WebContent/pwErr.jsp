<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 재입력</title>
</head>
<body>

	<form action="detail.jsp" method="get">
	<h2>비밀번호 오류</h2>
	다시 입력 해주세요
	<br />
	<input type = "text" name = "pw4" placeholder="비밀번호 재입력" required="required" />
	<br />
	<input type="button" value="글 목록" onclick="location.href='visit.jsp'" />
	<input type="submit" value="글 삭제" />
	</form>

</body>
</html>