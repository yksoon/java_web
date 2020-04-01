<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></meta>
	<title>게시판 목록</title>

	<style type="text/css">
		* {font-size: 9pt;}
		p {width: 600px; text-align: right;}
		table thead tr th {background-color: gray;}
	</style>
</head>

<body>
	<form  action="" method="get"  >
	<p>
		<select name="searchType">
			<option value="ALL" selected="selected">전체검색</option>
			<option value="SUBJECT" <c:if test="${boardModel.searchType eq 'SUBJECT'}">selected="selected"</c:if>>제목</option>
			<option value="WRITER" <c:if test="${boardModel.searchType eq 'WRITER'}">selected="selected"</c:if>>작성자</option>	
			<option value="CONTENTS" <c:if test="${boardModel.searchType eq 'CONTENTS'}">selected="selected"</c:if>>내용</option>
		</select>
		
		<input type="text" name="searchText" value='<c:out value="${boardModel.searchText }"></c:out>' />
		<input type="submit" value="검색" />
	</p>
	</form>
	
	
	<table border="1" summary="게시판 목록">
		<caption>게시판 목록</caption>
		<colgroup>
			<col width="50" />
			<col width="300" />
			<col width="80" />
			<col width="100" />
			<col width="70" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록 일시</th>
				<th>조회수</th>
			</tr>
		</thead>

		<tbody>
		<c:choose>
			<c:when test="${totalCount==0 }">	<%-- if() 부분 --%>
			<tr>
				<td align="center" colspan="5">등록된 게시물이 없습니다.</td>
			</tr>
			</c:when>
			
			<c:otherwise>	<%-- else 부분 --%>
				<c:forEach var="board" items="${boardList }" varStatus="status">
			<tr>
				<!-- 번호 -->
				<td align="center">
					<c:out value="${totalCount - (status.index+1) + 1 - (boardModel.pageNum - 1) * boardModel.listCount}" />
				</td>
				<!-- 제목 -->
				<td>
					<a href="<c:url value="/board/boardViewServlet?num=${board.num}&pageNum=${boardModel.pageNum}&amp;searchType=${boardModel.searchType}&amp;searchText=${boardModel.searchText}" />"><c:out value="${board.subject}" /></a>
				</td>
				<!-- 작성자 -->
				<td align="center">
					<c:out value="${board.writer}" />
				</td>
				<!-- 등록일자 -->
				<td align="center">
					<c:out value="${fn:substring(board.reg_date, 0, 10)}" />
				</td>
				<!-- 조회수 -->
				<td align="center">
					<c:out value="${board.hit }" />
				</td>
			</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>

		<tfoot>	<!-- 페이지 번호 -->
			<tr>
				<td align="center" colspan="5">
					<c:out value="${pageNavigator }" escapeXml="false" />
				</td>
			</tr>
		</tfoot>
	</table>
	<!-- 글목록 종료 -->
	
	
	<p>	<!-- 목록 버튼 / 글쓰기 버튼 -->
		<input type="button" value="목록"  onclick="location.href='<c:url value="/board/boardListServlet" />'"/>
		<input type="button" value="글쓰기"  onclick="location.href='<c:url value="/board/boardWriteServlet" />'" />
	</p>
</body>
</html>