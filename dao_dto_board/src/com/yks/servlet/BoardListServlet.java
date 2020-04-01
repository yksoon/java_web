package com.yks.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yks.dao.BoardDAO;
import com.yks.model.BoardModel;

import util.PageNavigator;

@WebServlet("/board/boardListServlet")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** BOARD DAO */
	private BoardDAO boardDAO = null;	
	
    public BoardListServlet() {
        super();
    }
    
    /**
     * GET 접근 시 (목록 조회 접근 시)
     * 1. 처음 요청이 들어왔을 때 (페이지 번호, 검색 종류, 검색어 없음)
     * 2. 검색 종류와 검색어를 입력한 후, 검색 버튼을 클릭 했을 때 (페이지 번호 없음)
     * 3. 페이지 번호를 클릭 했을 때 (검색 종류, 검색어 없음)
     * 4. 글쓰기 후, 글 수정 후, 글 삭제 후 (페이지 번호, 검색 종류, 검색어 없음)
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터 (pageNum , searchType, searchText)
		String pageNum = request.getParameter("pageNum");	// 페이지 번호
		String searchType = request.getParameter("searchType");	// 검색 종류
		String searchText = request.getParameter("searchText");	// 검색어
		
		if (pageNum == null){
			pageNum = "1";		// 전달된 페이지 번호가 없으면 1
		}
		if (searchText == null) {
			searchType = "";	// 전달된 검색 종류가 없으면 ""를 용하여 초기화
			searchText = "";	// 전달된 검색어가 없으면 ""를 이용하여 초기화
		}
		
		// mySQL 한글
//		String searchTextUTF8 = new String(searchText.getBytes("ISO-8859-1"), "UTF-8");
		
		// 모델에 파라미터값 설정 (BoardModel)
		BoardModel boardModel = new BoardModel();
		boardModel.setPageNum(pageNum);
		boardModel.setSearchType(searchType);
		boardModel.setSearchText(searchText);
		
		// DAO (DB의 테이블에 접속하여 쿼리를 실행할 수 있는 메서드 보유 객체 생성)
		this.boardDAO = new BoardDAO();
		
		// 게시물 총 수 (목록 아래에 페이지 번호를 계산하기 위한 메서드 호출)
		int totalCount = this.boardDAO.selectCount(boardModel);
//		System.out.println(totalCount);
		
		// 게시물 목록을 얻는 쿼리 실행 (결과값을 ArrayList<BoardModel>로 반환 받음)
		List<BoardModel> boardList = this.boardDAO.selectList(boardModel);
		
		// view 사용될 객체에 전달할 값 설정
		request.setAttribute("totalCount", totalCount);
		
		// 목록 하단 페이지 번호출력을 위한 객체 생성
		PageNavigator pNavigator = new PageNavigator();
		
		
		String p_navi = pNavigator.getPageNavigator(totalCount, boardModel.getListCount(), boardModel.getPagePerBlock(), Integer.parseInt(pageNum), searchType, searchText);
		
		request.setAttribute("pageNavigator", p_navi);	// 페이지 번호들
		request.setAttribute("boardList", boardList);	// 조회 결과 리스트
		request.setAttribute("boardModel", boardModel);	// 모델
		
		// view 보내기
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/board/boardList.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
