package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

import static com.cdac.utils.DBUtils.*;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet(urlPatterns = "/login",loadOnStartup = 3)
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

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
			System.out.println("in init");
			// open connection
			openConnection();
			// create dao instance
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			// re throw the exception to the caller - WC - so that WC will mark this servlet
			// un available for further servicing
			// Ctor of ServletException(String mesg,Throwable rootCause)
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
			// dao's cleanup + close cn
			userDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override // inherited from HttpServlet
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set cont type
		response.setContentType("text/html");
		// 2. get PW
		try (PrintWriter pw = response.getWriter()) {
			// 3. read request params
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
			// 4. Invoke dao's method for user authentication
			User user = userDao.authenticateUser(email, pwd);
			//5. Check if valid or invalid login
			if(user == null)
			{
				//=> invalid login->, send err mesg with a retry link to the clnt
				pw.print("<h5> Invalid Login , "
						+ "Please <a href='login.html'>Retry</a></h5>");						
			} else {
				//6. In case of successful auth , store user details in a Cookie
				//API of javax.servlet.http.Cookie(String cookieName,String cookieValue)
				Cookie c1=new Cookie("user_details", user.toString());
				//7. Add cookie/s in resp header
				response.addCookie(c1);
				//=> authentication success --> continue to role based authorization
				/*
				 * How to redirect client to the next page ?
				 * API of HttpServletResponse
				 * public void sendRedirect(String location) throws IOException
				 * location - can relative to the current web app.
				 * 
				 */
				if(user.getUserRole().equals("admin"))
				{
					//admin login --> redirect the client to admin page
					response.sendRedirect("admin_page");
					
				} else {
					//=> voter login
					if(user.isStatus())
					{
						//=> already voted voter , redirect to logout page
						response.sendRedirect("logout");
						
					} else {
						//=> not yet voted voter , redirect the client candidate list page
						response.sendRedirect("candidate_list");
					}
				}
			}
		} catch (Exception e) {
			// re throw the same exc to the caller(WC)
			throw new ServletException("err in doXXX of " + getClass(), e);
		}
	}

}
