package com.cdac.pages;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
/*
 * to confirm servlet life cycle
 */
@WebServlet("/hello")
public class HelloWordServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-get ");
		//1. set resp content type
		/*
		 * API of ServletResponse i/f
		 * public void setContentType(String contType)
		 */
		resp.setContentType("text/html");
		//2. To send text response from server --> clnt
		/*
		 * API of ServletResponse i/f
		 * public PrintWriter getWriter() throws IOException
		 * public ServletOutputStream getOutputStream() throws IOException
		 */
		try (PrintWriter pw=resp.getWriter())
		{
			pw.print("<h4> Welcome 2 Servlets @ "+LocalDateTime.now()+"</h4>");
		}
		
		
		
	}

	@Override
	public void destroy() {
		System.out.println("in destroy ");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init ");
	}
	

}
