package management.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import management.dto.ManagementDTO;
import management.dao.ManagementDAO;

public class MainListController implements Controller {

	private ManagementDAO dao;
	
	public void setDao(ManagementDAO dao) {
		this.dao = dao;
		System.out.println("setDao() 호출(dao): " + dao);
	}
	
	public MainListController() {
		
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MainListController 실행");
		
		ArrayList<ManagementDTO> mainlist = dao.mainList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main_form"); // main_form.jsp
		
		mav.addObject("mainlist", mainlist);
		
		return mav; // DispatcherServlet에게 전달
	}

}