<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	<%-- <%@ page  errorPage="my_err_handler.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int a = 100;
	int b	= 0;
	int result=a/b;
	%>
	<h5> Result - <%= result %></h5>
</body>
</html>