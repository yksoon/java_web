<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	ko_KR / en_US / en_GB
	<fmt:setLocale value="ko_KR"/>
	number : <fmt:formatNumber value="9876543.61" type="number" />
	currency : <fmt:formatNumber value="9876543.61" type="currency" />
	percent : <fmt:formatNumber type="percent">9876543.61</fmt:formatNumber>
	
	pattern = ".000" : <fmt:formatNumber value="9876543.61" pattern=".000" />
	pattern = "#.#00.0#" : <fmt:formatNumber value="9876543.612345" pattern="#,#00.0#" />
	<br />
	
	ko_KR / en_US / en_GB
	<fmt:setLocale value="en_US"/>
	number : <fmt:formatNumber value="9876543.61" type="number" />
	currency : <fmt:formatNumber value="9876543.61" type="currency" />
	percent : <fmt:formatNumber type="percent">9876543.61</fmt:formatNumber>
	
	pattern = ".000" : <fmt:formatNumber value="9876543.61" pattern=".000" />
	pattern = "#.#00.0#" : <fmt:formatNumber value="9876543.612345" pattern="#,#00.0#" />
	<br />
	
	ko_KR / en_US / en_GB
	<fmt:setLocale value="en_GB"/>
	number : <fmt:formatNumber value="9876543.61" type="number" />
	currency : <fmt:formatNumber value="9876543.61" type="currency" />
	percent : <fmt:formatNumber type="percent">9876543.61</fmt:formatNumber>
	
	pattern = ".000" : <fmt:formatNumber value="9876543.61" pattern=".000" />
	pattern = "#.#00.0#" : <fmt:formatNumber value="9876543.612345" pattern="#,#00.0#" />
</body>
</html>