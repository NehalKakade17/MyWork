package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.dao.CandidateDao;
import com.cdac.dao.CandidateDaoImpl;
import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

import static com.cdac.utils.DBUtils.*;

/**
 * Servlet implementation class ValidationServlet
 */
//@WebServlet(urlPatterns = "/login",loadOnStartup = 1)
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private CandidateDao candidateDao;
	
	//Can you add a parameterized ctor to the Servlet ? NO !
	
	public ValidationServlet() {
		System.out.println("in def ctor "+getServletConfig());//null
	}
	/*
	 * WC creates - ServletConfig object , once per servlet , after 
	 * class loading n creating singleton instance (def ctor) , 
	 * then WC creates it,just before calling init method
	 * 
	 */
	

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
			ServletConfig config=getServletConfig();
			System.out.println("in init "+config);//not null !
			String url=config.getInitParameter("url");
			String userName=config.getInitParameter("user_name");
			String pwd=config.getInitParameter("password");
			// open connection
			openConnection(url,userName,pwd);
			// create user dao instance
			userDao = new UserDaoImpl();
			//create candidate dao instance
			candidateDao=new CandidateDaoImpl();
		} catch (Exception e) {
			// re throw the exception to the caller - 
			//WC - so that WC will mark this servlet
			// un available for further servicing (i.e it won't continue with the 
			//remaining life cycle
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
			candidateDao.cleanUp();
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
			// 3. read request params sent from clnt --> servlet
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
				//6. In case of successful authentication , 
				//6.1 get HttpSession from WC
				HttpSession session=request.getSession();//new HttpSession
				System.out.println("HttpSession "+session);//o/p - F.Q imple class (catalina)@hashCode
				//6.2 display session id - debug
				System.out.println("Session ID from validation page "+session.getId());//long string
				//6.3 if sesison is new or existing
				System.out.println("Session is new "+session.isNew());//true
				//6.4 Save user details under session scope
				session.setAttribute("user_dtls", user);
				//6.5 Save user dao under sesison scope
				session.setAttribute("user_dao", userDao);
				//6.6 Save candidate dao under session scope
				session.setAttribute("candidate_dao", candidateDao);
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
					/*
					 * WC - 1. Clears (empties) resp buffer (PW)
					 * 2. sends temp redirect response 
					 * SC 302 , resp headers - Location-admin_page,content-length=0
					 * ,Set-Cookie - user_details - user's details(string)
					 * Web browser - checks - privacy settings -
					 * blocked - session tracking fails !!!!!!!!!!!!!!!!!
					 * accepted - chks age of the cookie(expiry) : -1 => stores it in cache
					 * web browser auto sends NEXT redirect request
					 * URL - http://host:port/day3.1/admin_page ,method=GET
					 * 
					 */
					
				} else {
					//=> voter login
					if(user.isStatus())
					{
						//=> already voted voter , redirect to logout page
						response.sendRedirect("logout");
						
					} else {
						//=> not yet voted voter , redirect the client candidate list page
						response.sendRedirect("candidate_list");
						//Redirect resp - SC 302 , Location:candidate_list , 
						//Set-Cookie -JSESSIONID-dfgsdf565hjfgh,Body : empty
					}
				}
			}
		} catch (Exception e) {
			// re throw the same exc to the caller(WC)
			throw new ServletException("err in doXXX of " + getClass(), e);
		}
	}

}
