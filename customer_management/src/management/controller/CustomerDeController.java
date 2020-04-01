package management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import management.dto.ManagementDTO;
import management.dao.ManagementDAO;

/**
 * AbstractCommandController를 상속 받음._browser
 * 전달된 수정 값들을 DAO의 update()로 수정하고 list.jsp를 호출 
 */
public class CustomerDeController extends AbstractCommandController {

	private ManagementDAO dao;
	// BoardDAO dao = new BoardDAO();
	// board-servlet.xml
	// <property name="comman...">
	
	public void setDao(ManagementDAO dao) {
		this.dao = dao;
	}

	public CustomerDeController() {
		// TODO Auto-generated constructor stub
	}

	public CustomerDeController(Class commandClass) {
		super(commandClass);
		// TODO Auto-generated constructor stub
	}

	public CustomerDeController(Class commandClass, String commandName) {
		super(commandClass, commandName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException error) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String customerNo = request.getParameter("customerNo");
		// BoardCommand data = (BoardCommand) command;
		ManagementDTO data = (ManagementDTO) command;
		
		int customerNo2 = Integer.parseInt(customerNo);
		System.out.println(customerNo);
		System.out.println(customerNo2);
		
		// dao.delete(data);
		dao.deleteCustomer(customerNo2);
		
		return new ModelAndView("redirect:/customerlist.do");
	}

}
