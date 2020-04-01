package com.yks.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yks.dao.BoardDAO;
import com.yks.model.BoardModel;

@WebServlet("/board/boardDeleteServlet")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** BOARD DAO */
	private BoardDAO boardDAO = null;
       
    public BoardDeleteServlet() {
        super();
    }
    
    /**
     * GET 접근 시 (상세조회 접근 시)
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 (num, pageNum, searchType, searchText)
		String num = request.getParameter("num");
		String pageNum = request.getParameter("pageNum");
		String searchType = request.getParameter("searchType");
		String searchText = request.getParameter("searchText");
		
		// mySQL 한글 저장
//		String searchTextUTF8 = new String(searchText.getBytes("ISO-8859-1"), "UTF-8");
//		String searchTextUTF8_E = URLEncoder.encode(searchTextUTF8, "UTF-8");
		
		// 모델에 파라미터 값 설정 (BoardModel)
		BoardModel boardModel = new BoardModel();
		boardModel.setNum(Integer.parseInt(num));
		boardModel.setPageNum(pageNum);
		boardModel.setSearchType(searchType);
		boardModel.setSearchText(searchText);
		
		// 게시물 삭제 (BoardDAO => delete() 호출)
		this.boardDAO = new BoardDAO();
		this.boardDAO.delete(boardModel);
		
		// 페이지 이동
		response.sendRedirect("boardListServlet?pageNum=" + pageNum + "&searchType=" + searchType + "&searchText=" + searchText);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
