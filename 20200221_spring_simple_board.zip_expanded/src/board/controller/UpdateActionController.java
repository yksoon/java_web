package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import board.command.BoardCommand;
import board.dao.BoardDAO;

public class UpdateActionController extends AbstractCommandController {
	
	BoardDAO dao; 

    
    public void setDao(BoardDAO dao) {
        this.dao = dao;
        System.out.println("setDao()호출됨(dao) : "+dao);
    }
    

	@Override
	protected ModelAndView handle(HttpServletRequest request, 
											 HttpServletResponse response, 
											 Object command, 
											 BindException error) throws Exception {
		
        return null;
	}

}



