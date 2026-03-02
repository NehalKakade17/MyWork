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
	request.setAttribute("mesg2", mesg2);
	request.setAttribute("mesg1", mesg1);
	pageContext.setAttribute("nm", 1000);//page scoped attribute
	%>
	<h5>Private instance variable - <%= mesg1 %></h5> <!-- This uses the instance variable mesg1 -->
    
    <h5>Request scoped attribute (mesg2) - <%= request.getAttribute("mesg2") %></h5> <!-- mesg2 via request scope -->

    <h5>Page scoped attribute (nm) - ${pageScope.nm}</h5> <!-- Page scope attribute -->
	<%--include test6.jsp here --%>
	<%@ include file="test6.jsp" %>
</body>
</html>