package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;

/**
 * 전달된 num을 이용하여 DAO의 delete()로 삭제하고 list.jsp를 호출
 * @author USER
 *
 */
public class DeleteActionController implements Controller {

	public DeleteActionController() {
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
