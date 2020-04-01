package com.yks.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yks.dao.BoardDAO;
import com.yks.model.BoardModel;

@WebServlet("/board/boardModifyServlet")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** BOARD DAO */
	private BoardDAO boardDAO = null;	
	
    public BoardModifyServlet() {
        super();
    }
    
    /**
     * GET 접근시 (수정폼 접근 시)
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 (num, pageNum, searchType, searchText)
		String num = request.getParameter("num");
		String pageNum = request.getParameter("pageNum");
		String searchType = request.getParameter("searchType");
		String searchText = request.getParameter("searchText");
		
		// mySQL 한글
//		String searchTextUTF8 = new String (searchText.getBytes("ISO-8859-1"), "UTF-8");
		
		// 모델에 파라미터 값 설정 (BoardModel)
		BoardModel boardModel = new BoardModel();
		boardModel.setNum(Integer.parseInt(num));
		boardModel.setPageNum(pageNum);
		boardModel.setSearchType(searchType);
		boardModel.setSearchText(searchText);
		
		// 게시물 상세 조회 (BoardDAO => selectOne() 호출)
		this.boardDAO = new BoardDAO();
		boardModel = this.boardDAO.select(boardModel);
		
		// View 사용될 객체 설정
		request.setAttribute("boardModel", boardModel);
		
		// View 보내기 (boardModify.jsp : forward(request, response) )
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/board/boardModify.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST 한글 파라미터 깨짐 처리
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 (num, subject, writer, contents, pageNum, searchType, searchText)
		String num = request.getParameter("num");		// hidden
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		String pageNum = request.getParameter("pageNum");	// hidden
		String searchType = request.getParameter("searchType");	// hidden
		String searchText = request.getParameter("searchText");	// hidden
		String ip = request.getRemoteAddr();
		
//		String searchTextUTF8_E = URLEncoder.encode(searchTextUTF8, "UTF-8");
				
		// 모델에 파라미터 값 설정 (BoardModel)
		BoardModel boardModel = new BoardModel();
		boardModel.setNum(Integer.parseInt(num));
		boardModel.setSubject(subject);
		boardModel.setWriter(writer);
		boardModel.setContents(contents);
		boardModel.setIp(ip);
		boardModel.setPageNum(pageNum);
		boardModel.setSearchType(searchType);
		boardModel.setSearchText(searchText);
		
		// 게시물 수정 처리 (BoardDAO => update() 호출)
		this.boardDAO = new BoardDAO();
		this.boardDAO.update(boardModel);
		
		// 페이지 이동
		response.sendRedirect("boardViewServlet?num="+num + "&pageNum=" + pageNum + "&searchType" + searchType + "&searchText" + searchText);
	}

}
