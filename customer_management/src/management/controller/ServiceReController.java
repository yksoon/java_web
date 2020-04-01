package management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import management.dao.ManagementDAO;
import management.dto.ManagementDTO;

/**
 * Controller 구현 받음._add
 * 전달된 num을 이용하여 DAO의 retrieve()를 통해 해당 레코드만 DTO객체에 담아 retrieve.jsp를 호출
 */
public class ServiceReController implements Controller {

	private ManagementDAO dao;
	
	public void setDao(ManagementDAO dao) {
		this.dao = dao;
	}

	public ServiceReController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nailNo = request.getParameter("nailNo");
		
		ManagementDTO data = dao.selectAddMain(null, nailNo);
		
		ModelAndView mav = new ModelAndView("service_add_mod_form");
		
		mav.addObject("data", data);
		
		return mav;
	}

}
