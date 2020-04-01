<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"></meta>
	<title>게시판 수정 폼</title>
	<script type="text/javascript" src="<c:url value="/ckeditor/ckeditor.js" />"></script>
	
	<style type="text/css">
		* {font-size: 9pt;}
		p {width: 600px; text-align: right;}
		table tbody tr th {background-color: gray;} 
	</style>
	
</head>
<body>

	<form action="<c:url value="/board/boardModifyServlet" />" method="post" >
		<input type="hidden" name="num" value="<c:out value="${boardModel.num }" />" />
		<input type="hidden" name="pageNum" value="<c:out value="${boardModel.pageNum }"/>" />
		<input type="hidden" name="searchType" value="<c:out value="${boardModel.searchType }"/>" />
		<input type="hidden" name="searchText" value="<c:out value="${boardModel.searchText }"/>" />
		
		<table border="1" summary="게시판 수정 폼">
			<caption>게시판 수정 폼</caption>
			<colgroup>
				<col width="100" />
				<col width="500" />
			</colgroup>
			<tbody>
				<tr>
					<th align="center">제목</th>
					<td>
					<input type="text" name="subject" size="80" maxlength="100" value="<c:out value="${boardModel.subject }"/>"  /></td>
				</tr>
				<tr>
					<th align="center">작성자</th>
					<td><input type="text" name="writer" maxlength="20" value="<c:out value="${boardModel.writer }"/>" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea name="contents" cols="80" rows="10">
							<c:out value="${boardModel.contents }" escapeXml="false" />
						</textarea>
						<script>
						CKEDITOR.replace('contents');
						</script>
					</td>
				</tr>
			</tbody>
		</table>
		
		<p>
			<input type="button" value="목록" onclick="location.href='<c:url value="/board/boardListServlet?pageNum=${boardModel.pageNum}&amp;searchType=${boardModel.searchType}&amp;searchText=${boardModel.searchText}"/>'" />
			<input type="submit" value="글수정" />
		</p>
	
	</form>
</body>
</html>