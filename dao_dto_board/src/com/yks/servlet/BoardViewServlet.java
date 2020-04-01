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

@WebServlet("/board/boardViewServlet")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** BOARD DAO */
	private BoardDAO boardDAO = null;
    
    public BoardViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 (num, pageNum, searchType, searchText)
		String num = request.getParameter("num");
		String pageNum = request.getParameter("pageNum");
		String searchType = request.getParameter("searchType");
		String searchText = request.getParameter("searchText");
		
		// mySQL 한글
//		String searchTextUTF8 = new String (searchText.getBytes("ISO-8859-1"), "UTF-8");
		
		//모델에 파라미터 값 설정 (BoardModel)
		BoardModel boardModel = new BoardModel();
		boardModel.setNum(Integer.parseInt(num));
		boardModel.setPageNum(pageNum);
		boardModel.setSearchType(searchType);
		boardModel.setSearchText(searchText);
		
		// 게시물 상세 조회 (BoardDAO => selectOne() 호출)
		this.boardDAO = new BoardDAO();
		boardModel = this.boardDAO.select(boardModel);
		
		// 게시물 조회수 증가 (BoardDAO => updateHit() 호출)
		this.boardDAO.updateHit(boardModel);
		
		// View 사용될 객체 설정
		request.setAttribute("boardModel", boardModel);
		
		// View 보내기 (boardModify.jsp : forward(request, response) )
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/board/boardView.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
