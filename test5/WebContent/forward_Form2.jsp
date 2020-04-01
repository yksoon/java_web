<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>포워딩 될 페이지에 파라미터값 전달하기 예제</h1>
	
	<form action="forwardFrom2.jsp" method="post">
		이름: <input type="text" id="name" name="name" /> <br /><br />
		당신의 혈액형은? <p>
		
		<input type="radio" id="a" name="bloodType" value="a" />
		<label for="a">A형</label><br />
		
		<input type="radio" id="b" name="bloodType" value="b" />
		<label for="b">B형</label><br />
		
		<input type="radio" id="o" name="bloodType" value="o" />
		<label for="o">O형</label><br />
		
		<input type="radio" id="ab" name="bloodType" value="ab" />
		<label for="ab">AB형</label><br />
		
		<p>
		<input type="submit" value="보내기" />
	</form>

</body>
</html>