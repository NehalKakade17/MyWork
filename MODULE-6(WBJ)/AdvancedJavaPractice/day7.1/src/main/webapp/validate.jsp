<%@page import="com.cdac.pojos.User"%>
<%@page import="java.util.HashMap,java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	HashMap<String, User> users;

	public void jspInit() {
		//create an empty map n populate it
		users = new HashMap<>();//empty HM -size=0,initCapa=16,LoadFactor=.75f
		//add users
		users.put("rama@gmail.com", new User("Rama Waze", "rama@gmail.com", "12345"));
		users.put("anish@gmail.com", new User("Anish Singh", "anish@gmail.com", "2345"));
	}%>

<body>
	<%
	//1. read req params sent from clnt --> server
	String email = request.getParameter("em");
	String pwd = request.getParameter("pass");
	//2. get user details by it's email
	User userDetails = users.get(email);
	if (userDetails != null) {
		//email is valid
		if(userDetails.getPassword().equals(pwd))
		{
			//valid login -> store user details - under session scope
			session.setAttribute("user_dtls", userDetails);
			//URL rewriting + redirect the clnt to the next page in the NEXT redirect request
			//API of HttpServletResponse - public String encodeRedirectURL(String location)
			response.sendRedirect(response.encodeRedirectURL("details.jsp"));
			
		} else {
			//invalid password
			out.print("<h5> Invalid Password , Please <a href='login.jsp'>Retry</a></h5>");
		}

	} else {
		//invalid email
		out.print("<h5> Invalid Email , Please <a href='login.jsp'>Retry</a></h5>");

	}
	%>

</body>
</html>