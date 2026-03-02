<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log out Page</title>
</head>
<body>
	<%--session.getAttribute("user_dtls").getName() -> sent to clnt --%>
	<h5>Hello , ${sessionScope.user_dtls.name}</h5>
	<%
	session.invalidate();
	%>
	<h6>You have logged out ...</h6>
	<h5>
		<a href="login.jsp">Visit Again</a>
	</h5>
</body>
</html>