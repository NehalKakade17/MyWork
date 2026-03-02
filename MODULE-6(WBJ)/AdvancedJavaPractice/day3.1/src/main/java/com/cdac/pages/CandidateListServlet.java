package com.cdac.pages;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 * value | urlPatterns
 */
@WebServlet("/candidate_list")
public class CandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//set cont type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
            // Retrieve email from cookies
            String email = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user_email")) {
                        email = cookie.getValue();
                        break;
                    }
                }
            }
            if (email != null) {
                pw.print("<h5> in candidate list page </h5>");
                pw.print("<h5> Hello, " + email + "</h5>");
            } else {
                pw.print("<h5> No email found in cookies!</h5>");
            }
        }
		//Get PW
//		try(PrintWriter pw=response.getWriter()) {
//			pw.print("<h5> in candidate list page </h5>");
//			pw.print("<h5> Hello , "+request.getParameter("em")+"</h5>");
//		}

	}

}
