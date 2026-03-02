<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5>From next page....</h5>
	<%--display attribute values , using EL syntax --%>
	<h5>Page scoped attribute - ${pageScope.nm1}</h5>
	<h5>Request scoped attribute - ${requestScope.nm2}</h5>
	<h5>Session scoped attribute - ${sessionScope.nm3}</h5>
	<h5>Application scoped attribute - ${applicationScope.nm4}</h5>
</body>
</html>