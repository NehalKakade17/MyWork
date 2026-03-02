package com.cdac.pages;



import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;




import static com.cdac.utils.DBUtils.*;

/**
 * Servlet implementation class ValidationServlet
 */

public class SetUpDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	/*
	 * Rule regarding method overriding n exc handling Overriding form of the method
	 * , CAN NOT add any NEW or BROADER CHECKED exceptions
	 * 
	 */
	// overriding form of the init() - inherited from GenericServlet
	@Override
	public void init() throws ServletException {
		try {
			ServletConfig config = getServletConfig();
			String url = config.getInitParameter("url");
			String userName = config.getInitParameter("user_name");
			String pwd = config.getInitParameter("password");
			// open connection
			openConnection(url, userName, pwd);
		} catch (Exception e) {
			throw new ServletException("err in init of " + getClass(), e);
		}

	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		try {
			System.out.println("in destroy");
			// close cn
			closeConnection();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy " + getClass(), e);
		}
	}

}
