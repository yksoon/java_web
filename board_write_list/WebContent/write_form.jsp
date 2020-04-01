<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	<!-- HTML5 방식 -->
<html>
<head>
<meta charset="UTF-8">	<!-- HTML 방식 -->
<title>글쓰기 화면</title>
</head>
<body>
	<h1>글쓰기</h1>
	<form action="write.jsp" method="get">
	작성자<input type = "text" size = "50" name = "writer" required="required"/>
	<br /><br />
	제목   <input type = "text" size = "100" name = "title" required="required"/>
	<br /><br />
	내용   <textarea rows="10" cols="100" name = "contents" required="required"></textarea>
	<br /><br />
	<input type = "button" value = "글목록" onclick = "location.href='list.jsp'" />
	<input type = "submit" value = "글저장" />
	<input type = "reset" value = "취소" onclick = "location.href='list.jsp'" />
	</form>
</body>
</html>