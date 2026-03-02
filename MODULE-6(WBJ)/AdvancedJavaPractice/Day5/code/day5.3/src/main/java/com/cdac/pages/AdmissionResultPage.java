package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.pojos.Student;

/**
 * Servlet implementation class AdmissionResultPage
 */
@WebServlet("/result")
public class AdmissionResultPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		// get PW
		try (PrintWriter pw = response.getWriter()) {
			// 1. Get details from request scope
			Student student1 = (Student) request.getAttribute("student_dtls");
			pw.print("<h5> Hello " + student1.getFirstName() + " " + student1.getLastName() + "</h5>");
			// 2. check admission status
			if (student1.isAdmitted())
				pw.print("<h5> Congratulations ! , You are admitted in the Course " + student1.getCourse() + "</h5>");
			else 
			pw.print("<h5> Sorry  ! , You can't be admitted in the Course " + student1.getCourse() + "</h5>");

		}
	}

}
