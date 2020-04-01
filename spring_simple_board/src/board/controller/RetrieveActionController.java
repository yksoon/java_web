package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 전달된 num을 이용하여 DAO의 retrieve()를 통해 해당 레코드만 DTO객체에 담아 retrieve.jsp를 호출
 * @author USER
 *
 */
public class RetrieveActionController implements Controller {

	public RetrieveActionController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
