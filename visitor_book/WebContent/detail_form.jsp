<%@page import="com.yks.visitor_book.ChangeEncodeClass"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.yks.visitor_book.DBClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 상세보기</title>
</head>
<body>
	<%
	DBClass.connectVisitorDB();
	ResultSet rs = DBClass.selectAll();
	
	String writer = null;
	String contents = null;
	String pw = null;
	int no2 = 0;
	while (rs.next()){
		int no = Integer.parseInt(request.getParameter("no"));
		
		if(no == rs.getInt(1)) {
			writer = ChangeEncodeClass.toUnicode(rs.getString(3));
			contents = ChangeEncodeClass.toUnicode(rs.getString(2));
			pw = ChangeEncodeClass.toUnicode(rs.getString(4));
			no2 = no;
		}
	
	}
	%>
	<h1>방명록 상세보기</h1>
		<form action="detail.jsp" method="get">
		작성자
		<br /> 
		<input type="text" size="20" readonly="readonly" value="<%= writer %>" />
		<br /><br />
		글 내용 
		<br />
		<textarea rows="10" cols="60" readonly="readonly"><%= contents %></textarea>
		<br /><br />
		비밀번호
		<br />
		<input type="text" size="10" name="pw2" required="required" />
		<br />
		<input type="button" value="글 목록" onclick="location.href='visit.jsp'" />
		<input type="submit" value="글 삭제" />
		
		<input type="hidden" readonly="readonly" name="pw3" value=<%= pw %> required="required" />
		<input type="hidden" readonly="readonly" name="no" value=<%= no2 %> required="required" />
		</form>
</body>
</html>