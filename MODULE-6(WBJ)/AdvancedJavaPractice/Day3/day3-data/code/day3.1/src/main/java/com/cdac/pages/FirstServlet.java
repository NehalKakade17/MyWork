package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 * value | urlPatterns
 */
@WebServlet(value="/test1",loadOnStartup = 1)
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("in init of "+getClass()+" "+Thread.currentThread());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy "+getClass()+" "+Thread.currentThread());

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet "+getClass()+" "+Thread.currentThread());
		//set cont type
		response.setContentType("text/html");
		//Get PW
		try(PrintWriter pw=response.getWriter()) {
			pw.print("<h5> Dynamic contents from the servlet deployed via annotaion "
		+new Date()+"</h5>");
		}//resp is actually sent / rendered / committed !

	}

}
