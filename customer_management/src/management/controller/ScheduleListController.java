package management.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import management.dto.ManagementDTO;
import management.dao.ManagementDAO;

public class ScheduleListController implements Controller {

	private ManagementDAO dao;
	
	public void setDao(ManagementDAO dao) {
		this.dao = dao;
		System.out.println("setDao() 호출(dao): " + dao);
	}
	
	public ScheduleListController() {
		
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ScheduleListController 실행");
		
		ArrayList<ManagementDTO> customerlist = dao.customerLists();
		ArrayList<ManagementDTO> servicelist = dao.serviceLists();
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("schedule_add_mod_form"); // service_list_form.jsp
		
		mav.addObject("customerlist", customerlist);
		mav.addObject("servicelist", servicelist);
		
		return mav; // DispatcherServlet에게 전달
	}

}