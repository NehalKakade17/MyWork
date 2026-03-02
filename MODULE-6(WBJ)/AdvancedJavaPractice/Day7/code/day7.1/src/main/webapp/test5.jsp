<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!String mesg1 = "some mesg!";//private instance variable
%>
<body>
	<%
	String mesg2 = "another mesg";//method local variable - within _jspService
	pageContext.setAttribute("nm", 1000);//page scoped attribute
	%>
	<%--include test6.jsp here --%>
	<%@ include file="test6.jsp" %>
</body>
</html>