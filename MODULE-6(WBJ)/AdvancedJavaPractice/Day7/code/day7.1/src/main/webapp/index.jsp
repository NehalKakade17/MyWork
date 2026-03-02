<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h4 align="center">
		Session ID -
		<%=session.getId()%></h4>
	<h5>
		<a href="test1.jsp?pid=100&name=Bread&price=50">Testing Scripting
			Elements</a>
	</h5>
	<h5>
		<a href="login.jsp">User Login</a>
	</h5>
	<h5>
		<a href="test2.jsp">Testing Centralized error handling</a>
	</h5>
	<h5>
		<a href="test3.jsp">Testing Different Scopes</a>
	</h5>
	<h5>
		<a href="test5.jsp">Testing include directive</a>
	</h5>
	<h5>
		<a href="test7.jsp?pid=101&name=Biscuits&price=40">Testing forward or include action</a>
	</h5>
</body>
</html>