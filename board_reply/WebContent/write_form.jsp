<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 쓰기</h1>
	
	<form action="write.jsp" method="get">
	작성자 
	<br />
	<input type="text" size="100" name="writer" required="required" />
	<br /><br />
	내용 
	<br />
	<textarea rows="10" cols="100" name="contents" required="required"> </textarea>
	<br /><br />
	<input type="submit" value ="저장" />
	<input type="reset" value="취소" onclick="location.href='list_form.jsp'" />
	
	</form>
</body>
</html>