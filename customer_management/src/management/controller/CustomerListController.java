package management.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import management.dto.ManagementDTO;
import management.dao.ManagementDAO;

public class CustomerListController implements Controller {

	private ManagementDAO dao;
	
	public void setDao(ManagementDAO dao) {
		this.dao = dao;
		System.out.println("setDao() 호출(dao): " + dao);
	}
	
	public CustomerListController() {
		
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CustomerListController 실행");
		
		ArrayList<ManagementDTO> customerlist = dao.customerList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customer_list_form"); // customer_list_form.jsp
		
		mav.addObject("customerlist", customerlist);
		
		return mav; // DispatcherServlet에게 전달
	}

}