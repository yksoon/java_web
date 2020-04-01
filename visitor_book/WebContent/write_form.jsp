<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>방명록 작성</title>
</head>
<body>
	<h1>방명록 작성</h1>
	<form action="write.jsp" method="get">
	비밀번호
	<br />
	<input type="password" size="50" name="pw" required="required" />
	<br /><br />
	작성자 
	<br />
	<input type="text" size="100" name="writer" required="required" />
	<br /><br />
	내용 
	<br />
	<textarea rows="10" cols="100" name="contents" required="required"> </textarea>
	<br /><br />
	<input type="submit" value ="저장" />
	<input type="reset" value="취소" onclick="location.href='visit.jsp'" />
	
	
	</form>
</body>
</html>