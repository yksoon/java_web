<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포워딩 될 페이지에 파라미터 값 전달하기</h1>
	
	<form action="fowardFrom3.jsp" method="post">
		이름 입력 : <input type="text" id="name" name="name" /> <br /><br />
		색 선택 : <br />
		<input type="radio" id="yellow" name="color" value="yellow" />
		<label for="yellow">노랑색</label> <br />
		
		<input type="radio" id="green" name="color" value="green" />
		<label for="green">초록색</label> <br />
		
		<input type="radio" id="blue" name="color" value="blue" />
		<label for="blue">파랑색</label> <br />
		
		<input type="radio" id="red" name="color" value="red" />
		<label for="red">빨강색</label> <br /><br />
		
		<input type="submit" name="확인" />
	</form>
</body>
</html>