<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="board.controller.ListActionController"%>
<%@page import="org.springframework.dao.support.DaoSupport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, board.dto.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 목록</title>
</head>

<body>
	<form action="#" method="get">
		<table border="1">
			<tr>
				<td align="center" colspan="5">*** 게시판 목록 ***&nbsp;&nbsp;&nbsp; 
					<a href="writeui.do">글쓰기</a></td>
			</tr>
			<tr>
				<td>번호</td> <td>제목</td> <td>작성자</td> <td>작성일</td> <td>조회수</td>
			</tr>
			<%
				ArrayList list = (ArrayList)request.getAttribute("list");
				
				if(list!=null){		// 데이터가 존재 한다면
					Iterator iter = list.iterator();	// 열거타입
					
					while(iter.hasNext()==true){
						BoardDTO data = (BoardDTO)iter.next();
						int num = data.getNum();
						String title = data.getTitle();
						String author = data.getAuthor();
						String content = data.getContent();
						String writeday = data.getDate();
						int readcnt = data.getReadcnt();
			%>
			
			<tr>
				<td align="center"><%= num %></td>
				<td><a href="retrieve.do?num=<%= num %>"><%= title %></a></td>
				<td><%= author %></td>
				<td><%= writeday.substring(0,10) %></td>
				<td><%= readcnt %></td>
			</tr>
			<%
					}	// END while
				}	// END if
			%>	
			
			<!-- 검색 기능 시작 -->
			<tr>
				<td colspan="5" align="center">
					<form action="search.do">
						<select name="searchName" size="1">
							<option value="author">작성자</option>
							<option value="title">제목</option>
						</select> 
						<input type="text" name="searchValue" />
						<input type="submit" value="검색" />
					</form>
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>

<%-- 
글 목록 및 검색 결과를 출력 
ListActionController 로부터 전달된 ArrayList 객체를
1. ArrayList 객체가 null 인지를 확인
2. null이 아닌 경우 Iterator 객체 추출
3. 전달된 각 데이터를 하나씩 추출
4. 추출될 때마다 DTO 객체로 형변환하고,
5. <table></table> 내에 한 줄씩 출력

제목은 "retrieve.do?num=글번호" 형태로 링크 설정.

글 목록 중 하나를 선택하면 해당 글 번호를 RetrieveActionController에게 전달.

글쓰기와 검색기능 보유
--%>