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
 * handle() 메소드 내에서 입력받은 값을 DAO의 write()로 저장하고 list.jsp를 호출
 * 
 * AbstractCommandController를 상속받은 이유:
 * ModelAndView handle의 매개 변수가 Controller interface와 다르기 때문
 * └사용자가 입력한 값을 BoardCommand가 입력받아 전달해주기 때문에_자동 주입이기 때문에 일반 controller로는 해결불가
 */
/**
 * AbstractCommandController가 가지고 있는 객체
 * 
 * 1. HttpServletRequest: 요청객체
 * 2. HttpServletResponse: 응답객체
 * 3. Object: 입력받은 값을 저장하는 객체
 * 4. BindException: 사용자로 부터 값을 입력 시, 에러가 발생하면 처리해주는 class
 */
public class ServiceAddController extends AbstractCommandController {

	private ManagementDAO dao;
	
	public void setDao(ManagementDAO dao) {
		this.dao = dao;
		System.out.println("setDao()호출됨(dao): " + dao);
	}

	public ServiceAddController() {
		// TODO Auto-generated constructor stub
	}

	public ServiceAddController(Class commandClass) {
		super(commandClass);
		// TODO Auto-generated constructor stub
	}

	public ServiceAddController(Class commandClass, String commandName) {
		super(commandClass, commandName);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException error) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ManagementDTO data = (ManagementDTO) command;
		String content = data.getContent();
		int price = data.getPrice();
		
		dao.addService(content, price);
		
		/**
		 * response.sendRedirec("list.jsp"); 또는 // <= Model1,2 방식(servlet)
		 * 
		 * ModelAndView mav = new ModelAndView();
		 * mav.setViewName("list");
		 * 
		 * 위에 ModelAndView() 안에 넣음으로서 생략이 가능하다.
		 * ModelAndView mav = new ModelAndView("list");
		 * 
		 * return mav;
		 */
		// 또는
		return new ModelAndView("redirect:/main.do"); // 위의 주석 문을 한줄로 처리
	}

}
