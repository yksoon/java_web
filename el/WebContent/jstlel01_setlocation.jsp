<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre>
		default location : <%= response.getLocale() %>
		set locale : ko <fmt:setLocale value="ko"/>
		now : <%= response.getLocale() %>
		set locale : ja <fmt:setLocale value="ja"/>
		now : <%= response.getLocale() %>
		set locale : en <fmt:setLocale value="en"/>
		now : <%= response.getLocale() %>
	</pre>
</body>
</html>