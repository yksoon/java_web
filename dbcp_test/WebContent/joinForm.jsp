<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	'*' 표시 항목은 필수 입력 항목입니다. <br />
	<form action="join" method="post">
		<table border="0">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required="required" /> * </td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" required="required" /> * </td>
			<td><input type="button" name="check" value="중복 체크"/></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><input type="password" name="pw" required="required" /> * </td>
			</tr>
			<tr>
				<td>암호 확인</td>
				<td><input type="password" name="pwCheck" required="required" /> * </td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="tel" name="phone" /></td>
			</tr>
			<tr>
				<td>등급</td>
				<td>
					<input type="radio" name="admin" value="1" />일반회원
					<input type="radio" name="admin" value="2" />관리자
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="확인" />
					<input type="reset" value="취소" onclick="location.href='main.jsp'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>