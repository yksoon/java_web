package board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

/**
 * handleRequest() 메서드내에서 DAO의 list() 결과 값을 list.jsp에게 ArrayList로 전달
 * @author USER
 *
 */
//Controller를 상속받는 이유 : 요청을 받아서 처리하기 위함.
public class ListActionController implements Controller {
	
	private BoardDAO dao;	// xml 문서에 의해 BoardDAO dao = new BoardDAO();
	
	public void setDao(BoardDAO dao){
		this.dao = dao;
		System.out.println("setDao() 호출됨(dao) : " + dao);
	}
	/*
	 * dao는 board-servlet.xml <bean name="list.do" ~~>
	 * <property ~~~> 에 의해 주입
	 */
	
	// Controller는 기본생성자가 없어도 됨.
//	public ListActionController() {
//	}
	
	/** ----------------------------------------------------------------------------------------------- **/
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		System.out.println("ListActionController 실행됨!");
		
		ArrayList<BoardDTO> list = dao.list();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list"); 	// list.jsp
		// ViewResolver 에서 .jsp를 추가 (board-servlet.xml 맨 마지막)
		
		// 서블릿 클래스의 request.setAttribute("list", list); 와 동일한 역할
		mav.addObject("list", list);	// addObject 로 변환됨
		
		return mav;
	}

}
