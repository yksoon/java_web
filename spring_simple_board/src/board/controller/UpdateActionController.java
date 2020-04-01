package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

/**
 * 전달된 수정 값들을 DAO의 update() 로 수정하고 list.jsp를 호출
 * @author USER
 *
 */
public class UpdateActionController extends AbstractCommandController {

	public UpdateActionController() {
		// TODO Auto-generated constructor stub
	}

	public UpdateActionController(Class commandClass) {
		super(commandClass);
		// TODO Auto-generated constructor stub
	}

	public UpdateActionController(Class commandClass, String commandName) {
		super(commandClass, commandName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
