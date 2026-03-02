<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5>From 1st page...</h5>
	<%
	//adding attributes under different scopes
	pageContext.setAttribute("nm1", 1234);//auto boxing (int-->Integer)->Object
	request.setAttribute("nm2", 2345);
	session.setAttribute("nm3", 3345);
	application.setAttribute("nm4", 4345);
	//	response.sendRedirect("test4.jsp");
	//forward
	RequestDispatcher rd = request.getRequestDispatcher("test4.jsp");
	rd.forward(request, response);
	%>
</body>
</html>