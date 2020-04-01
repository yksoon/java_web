package com.yks.test3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubscribeServlet
 */
@WebServlet({ "/SubscribeServlet", "/Subscribe" })
public class SubscribeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscribeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String agree = request.getParameter("AGREE");
		String result = null;
		HttpSession session = request.getSession();
		if(agree.equals("yes")) {
			String id = (String) session.getAttribute("ID");
			String password = (String) session.getAttribute("PASSWORD");
			String name = (String) session.getAttribute("NAME");
			PrintWriter writer = null;
			try{
//	 			String filePath = application.getRealPath();
				writer = new PrintWriter("C:/YKS/java_web/test3/WebContent/WEB-INF/" + id + ".txt");
				writer.println("아이디 : " + id);
				writer.println("패스워드 : " + password);
				writer.println("이름 : " + name);
				result = "SUCCESS";
			}
			catch (IOException ioe) {
				result = "FAIL";
			}
			finally {
				try {
					writer.close();
				}
				catch (Exception e){
					
				}
			}
		} else {
			result = "FAIL";
		}
		session.invalidate();
		response.sendRedirect("Result.jsp?RESULT=" + result);
	}

}
