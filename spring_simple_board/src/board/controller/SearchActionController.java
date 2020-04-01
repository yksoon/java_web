package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 전달된 num을 이용하여 DAO의 search()를 수행. 그 결과 값을 ArrayList 객체에 담아 list.jsp에게 전달
 * @author USER
 *
 */
public class SearchActionController implements Controller {

	public SearchActionController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
