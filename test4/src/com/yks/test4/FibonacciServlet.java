package com.yks.test4;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fibonacci")
public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BigInteger arr[];
	
    public FibonacciServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		arr = new BigInteger[100];
		arr[0] = new BigInteger("1");
		arr[1] = new BigInteger("2");
		for (int cnt = 2; cnt < arr.length; cnt++){
			arr[cnt]=arr[cnt-2].add(arr[cnt-1]);
		}
	}

	public void destroy() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("NUM");
		int num=Integer.parseInt(str);
		
		if (num>100){
			num=100;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<META charset='UTF-8'>");
		out.println("<TITLE>피보나치 수열</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		
		for (int cnt=0; cnt<num; cnt++){
			out.println(arr[cnt] + "");
		}
		
		out.println("</BODY>");
		out.println("</HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
