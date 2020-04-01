package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import board.command.BoardCommand;
import board.dao.BoardDAO;

/**
 * handle() 메서드 내에서 입력받은 값을 DAO의 write()로 저장하고 list.jsp를 호출
 * AbstractCommandController 를 상속받는 이유:
 * ModelAndView handle 의 매개변수가 Controller interface 와 다르기 때문
 * @author USER
 *
 */
public class WriteActionController extends AbstractCommandController {

	BoardDAO dao; // BoardDAO dao = new BoardDAO();

	public void setDao(BoardDAO dao) {
		this.dao = dao;
		System.out.println("setDao()호출됨(dao) : " + dao);
	}
	
	/**
	 * AbstractCommandController 가 가지고 있는 객체
	 * 1. HttpServletRequest : 요청객체
	 * 2. HttpServletResponse : 응답객체
	 * 3. Object : 입력받은 값을 저장하는 객체
	 * 4. BindException : 사용자로부터 값을 입력 시, 에러가 발생하면 처리해주는 class
	 */

	// 매개변수를 알기 쉽게 변환
	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException error) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		/** Spring 방식 **/
		// BoardCommand 는 상속받은 부모의 class이다.
		BoardCommand data = (BoardCommand) command;
		String author = data.getAuthor();
		String content = data.getContent();
		String title = data.getTitle();
		
		/**
		 * 	// Model2 방식
		 * String author = request.getParameter("author");
		 * String content = request.getParameter("content");
		 * String title = request.getParameter("title");
		 */
		
		dao.write(author, title, content);	// dao.write(data)
		
		/**
		 * response.sendRedirect("list.jsp"); 또는
		 * 
		 * ModelAndView mav = new ModelAndView():
		 * mav.setViewName("list");
		 * 
		 * return mav;
		 */
		// 또는
        return new ModelAndView("redirect:/list.do");	// 위의 주석 문을 한줄로 처리
	}

}
