<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	String mesg1 = "Hello , How r u ?";//private scoped non-static variable
	int pageVisit;
	//override JSP life cycle methods -
	public void jspInit() {
		System.out.println("in jsp init");
	}
	int count() {
		return ++pageVisit;
	}
	%>
<body>
	<h4 align="center">
		Session ID -
		<%=session.getId()%></h4>
	<h3>Product Details Via a Scriptlet</h3>
	<%
	int productId = Integer.parseInt(request.getParameter("pid"));
	String productName = request.getParameter("name");
	double productPrice = Double.parseDouble(request.getParameter("price"));
	out.print("<h5> Product Details " + productId + " " + productName + " " + productPrice + "</h5>");
	%>
	<hr />
	<h3>Product Name n Price Via JSP Expression</h3>
	<h5>
		Product Name -
		<%=request.getParameter("name")%></h5>
	<h5>
		Price -
		<%=productPrice%></h5>
		<h5> Private instance variable - <%= mesg1 %></h5>
		<h5>Page vists - <%= count() %></h5>
	<hr />
	<h3>EL Syntax examples</h3>
	<h5>Product ID - ${param.pid}</h5>
	<h5>Price - ${param.price}</h5>
	<h5>param - ${param}</h5>
	<%--pageContext.getSession().getId() --%>
	<h5>Session ID - ${pageContext.session.id}</h5>
	<h5>Cookie JSESSIONID - ${cookie.JSESSIONID.value}</h5>
	
</body>
<%!//JSP declaration block

	//override JSP life cycle methods -
	public void jspDestroy() {
		System.out.println("in jsp destroy");
	}%>
</html>