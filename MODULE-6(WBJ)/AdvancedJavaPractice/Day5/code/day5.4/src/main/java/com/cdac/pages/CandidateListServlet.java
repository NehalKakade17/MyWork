package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.dao.CandidateDao;
import com.cdac.pojos.Candidate;
import com.cdac.pojos.User;

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
			// 1.Get HttpSession from WC
			//servlet request to WC for to either create n return 
			//NEW HttpSession or return existing one !
			HttpSession hs = request.getSession();
			System.out.println("Session ID " + hs.getId());// same session id , provided cookies are accepted by the client
			System.out.println("Session is new from candidate list page " + hs.isNew());// false provided cookies are accepted
			// 2. Get user details from the Session scope
			User user = (User) hs.getAttribute("user_dtls");
			if (user != null) {
				// => session tracking : successful !(i.e cookies are accepted !)
				pw.print("<h5> Hello , " + user.getFirstName() + " " + user.getLastName() + "</h5>");
				// 3. get candidate dao from session
				CandidateDao candidateDao = (CandidateDao) hs.getAttribute("candidate_dao");
				// 4. Invoke candidate dao's method to get List of all candidates
				List<Candidate> allCandidates = candidateDao.getAllCandidates();
				// 5. Generate form dynamically - to render all canidate's list
				pw.print("<h5><form method='post' action='logout'>");
				for (Candidate c : allCandidates) {
					pw.print("<h5> <input type='radio' name='cid' value='" 
				+ c.getCandidateId() + "'>" + c.getName()+" "+c.getPartyName()
							+ "</input>");
				}
				pw.print("<input type='submit' value='Vote'/>");
				pw.print("</form></h5>");

			} else
				pw.print("<h5> No Cookies(JSESSIONID) found ! , Accept Cookies !!!!!</h5>");

		} catch (Exception e) {
			// re throw the exc to the caller(WC)
			throw new ServletException("err in doGet of " + getClass(), e);
		}

	}

}
