package jobServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jobClass.DAOClass;
import jobClass.ModelClass;

@WebServlet("/personal")
public class PersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DAOClass daoClass = null;
	
    public PersonalServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ModelClass mc = new ModelClass();
		
		String name = request.getParameter(mc.getName());
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("personal_form.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 파라미터 
		String name = request.getParameter("name");
		String engname = request.getParameter("engname");
		String writeday = request.getParameter("writeday");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String email2 = request.getParameter("email2");
		String phone = request.getParameter("phone");
		
		// 모델에 파라미터 값 설정 (modelClass)
		ModelClass mc = new ModelClass();
		mc.setName(name);
		mc.setEngname(engname);
		mc.setWriteday(writeday);
		mc.setBirthday(birthday);
		mc.setAddress(address);
		mc.setEmail(email);
		mc.setEmail2(email2);
		mc.setPhone(phone);
		
		// DB 등록
		this.daoClass = new DAOClass();
		this.daoClass.insertPersonal(mc);
		
		// 페이지 이동
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("confirm_form.jsp");
		requestDispatcher.forward(request, response);
	}

}
