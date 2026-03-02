package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.dao.CandidateDao;
import com.cdac.dao.UserDao;
import com.cdac.pojos.User;

/**
 * Servlet implementation class FirstServlet value | urlPatterns
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
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
			HttpSession session = request.getSession();
			// get voter details
			User voter = (User) session.getAttribute("user_dtls");
			if (voter != null) {
				pw.print("<h5>You have already voted ! "+voter.getLastName()+" </h5>");
			} else
				pw.print("<h5>No cookies , no sesison tracking!!!!!</h5>");
			// discard HttpSession
			session.invalidate();
			pw.print("<h5> You have logged out....</h5>");
		}

	}

	// Override doPost to handle form submission
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		// Get PW
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();
			// get voter details
			User voter = (User) session.getAttribute("user_dtls");
			if (voter != null) {
				pw.print("<h5>Hello , Voter !"+voter.getFirstName()+" </h5>");
				// user dao n candidate dao
				UserDao userDao = (UserDao) session.getAttribute("user_dao");
				CandidateDao candidateDao = (CandidateDao) session.getAttribute("candidate_dao");
				//invoke user dao's method to update voting status			
				pw.print("<h5> "+userDao.updateVotingStatus(voter.getUserId()));
				//get selected candidate id from incoming request param.
				int candidateId=Integer.parseInt(request.getParameter("cid"));
				//invoke candidate dao's method , to increment votes
				pw.print("<h5> "+candidateDao.incrementVotes(candidateId)+"</h5>");
			} else
				pw.print("<h5>No cookies , no session tracking!!!!!</h5>");
			//invalidate session
			session.invalidate();
			pw.print("<h5> You have logged out....</h5>");

		} catch (Exception e) {
			throw new ServletException("err in doPost : "+getClass(),e);
		}
	}

}
