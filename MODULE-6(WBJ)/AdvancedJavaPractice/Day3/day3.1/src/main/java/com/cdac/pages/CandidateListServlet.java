package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet value | urlPatterns
 */
@WebServlet("/candidate_list")
public class CandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		// Get PW
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5> in candidate list page </h5>");
			pw.print("<h5> Hello , " + request.getParameter("em") + "</h5>");
			/*
			 * retrieve user details from the cookie.
			 */
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals("user_details")) {
						pw.print("<h5> User details via Cookie " + c.getValue() + "</h5>");
					}
				}

			} else
				pw.print("<h5> No Cookies found ! , Accept Cookies !!!!!</h5>");

		}

	}

}
