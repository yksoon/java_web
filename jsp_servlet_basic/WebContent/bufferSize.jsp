<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer="4kb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력 버퍼의 크기 비교</title>
</head>
<body>
	출력 버퍼의 크기 : <%= out.getBufferSize() %>바이트
</body>
</html>