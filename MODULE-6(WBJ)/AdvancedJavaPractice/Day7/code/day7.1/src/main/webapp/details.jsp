<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--session.getAttribute("user_Dtls") toString -> sent clnt --%>
	<h4>Validated User Details - ${sessionScope.user_dtls}</h4>
	<%
	 String encURL=response.encodeURL("logout.jsp");
	%>
	<h5>
		<a href="<%= encURL %>">Log Me Out</a>
	</h5>
</body>
</html>