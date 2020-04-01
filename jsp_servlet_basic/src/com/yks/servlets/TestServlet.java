package com.yks.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // <form action ="TestServlet" method="get">
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//					�Ű��������� ���� �����ϵ� Ÿ���� ���� �ϸ� �ȵ�.
		// TODO Auto-generated method stub
//		response.getWriter().append("YKS at: ").append(request.getContextPath());
		int total = 0;
		for (int cnt = 1; cnt < 101; cnt++)
			total += cnt;
			
			PrintWriter out = response.getWriter();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>1���� 100���� ���ϴ� ����</TITLE></HEAD>");
			out.println("<BODY>");
			out.printf("1���� 100������ ���� = %d", total);
			out.println("</BODY>");
			out.println("</HTML>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
