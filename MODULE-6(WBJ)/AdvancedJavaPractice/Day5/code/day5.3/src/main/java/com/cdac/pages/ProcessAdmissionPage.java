package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.pojos.Course;
import com.cdac.pojos.Student;

/**
 * Servlet implementation class ProcessAdmissionPage
 */
@WebServlet("/process_admission")
public class ProcessAdmissionPage extends HttpServlet {
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
			// 1. get request params
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			int testScore = Integer.parseInt(request.getParameter("score"));
			Course selectedCourse = Course.valueOf(request.getParameter("course")
					.toUpperCase());
			//2. wrap these details in student class instance
			Student student=new Student(firstName, lastName, selectedCourse, testScore);
			//3. B.L to admit or not
			if(testScore >= selectedCourse.getMinScore())
				student.setAdmitted(true);
			//4. Save student details as an attribute -request.setAttribute(nm,val)
			request.setAttribute("student_dtls", student);//scope=current request only ! 
			//5. Create RequestDispatcher object to chain the SAME request
			//to the next page(resp generation : P.L presentation logic)
			//intermediate page(i.e ProcessFormPage) adding the resp to the PW's buffer
			pw.print("Resp from the 1st page .....");
			RequestDispatcher rd=request.getRequestDispatcher("result");
			rd.include(request, response);
			/*
			 * WC - internally ?????????
			 */
			System.out.println("control came back....");
		}
	}

}
