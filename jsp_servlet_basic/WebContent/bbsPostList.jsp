<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
</head>
<body>
	<h2>파일형 게시판 - 글목록 화면</h2>
	<br /><br />
	<form action="bbsPostReader.jsp" name="bbsPostList" method="get">
		<select name="list" size="20" multiple="multiple">
			
			<%
			String uri = "C:/YKS/java_web/jsp_servlet_basic/WebContent/WEB-INF/bbs/";
			File f = new File(uri);
			if(f.exists()){
			String[] filelist = f.list();
				for (int i = 0; i < filelist.length; i++){
					
				}
			}
			%>
		</select>
	</form>
	

</body>
</html>