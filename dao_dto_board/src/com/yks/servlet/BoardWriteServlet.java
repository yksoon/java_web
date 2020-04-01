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

/**
 * 게시판 등록 폼
 * @since 2020.02.14
 * @author USER
 *
 */
@WebServlet("/board/boardWriteServlet")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/** BOARD DAO */
	private BoardDAO boardDAO = null;	
       
    public BoardWriteServlet() {
        super();
    }
    
    /**
     * GET접근시 (등록 폼 접근 시)
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// View 내보내기 (boardWrite.jsp : forward(request, response) )
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/board/boardWrite.jsp");
		requestDispatcher.forward(request, response);
	}
	
	/**
	 * POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 글 파라미터 깨짐 처리
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 (subject, writer, contents, ip)
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String contents = request.getParameter("contents");
		
		// ip 주소 추출 (request,.getRemoteAddr() )
		String ip = request.getRemoteAddr();
		
		// 모델에 파라미터 값 설정 (BoardModel)
		BoardModel boardModel = new BoardModel();
		boardModel.setSubject(subject);
		boardModel.setWriter(writer);
		boardModel.setContents(contents);
		boardModel.setIp(ip);
		
		// 게시물 등록 (BoardDAO => insert() 호출)
		this.boardDAO = new BoardDAO();
		this.boardDAO.insert(boardModel);
		
		// 페이지 이동
		response.sendRedirect("./boardListServlet");
	}

}
