<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 등록 폼</title>
	<script type="text/javascript" src="<c:url value="/ckeditor/ckeditor.js" />"></script>
	<style type="text/css">
		*{font-size: 9pt;}
		p{width: 600px; text-align: right;}
		table tbody tr th{background-color: gray;}
	</style>
</head>

<body>
	<form action="./boardWriteServlet"  method="post" >
	
	<table border="1" summary="게시판 등록 폼">
		<caption>게시판 등록 폼</caption>
		
		<colgroup>
			<col width="100" />
			<col width="500" />
		</colgroup>
		
		<tbody>
		
			<tr>
				<th align="center">제목</th>
				<td><input type="text" name="subject" size="80" maxlength="100" required="required"/></td>
			</tr>
			
			<tr>
				<th align="center">작성자</th>
				<td><input type="text" name="writer" maxlength="20" required="required" /></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<textarea name="contents" cols="80" rows="10" ></textarea>
					<script>CKEDITOR.replace('contents');</script>
				</td>
			</tr>
		</tbody>
	</table>
	<p>
		<input type="button" value="목록" onclick="location.href='<c:url value="/board/boardListServlet" />'" />
		<input type="submit" value="글쓰기" />
	</p>
	</form>
</body>
</html>