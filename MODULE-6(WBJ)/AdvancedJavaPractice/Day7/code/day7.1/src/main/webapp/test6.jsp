<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h6>From the included page....</h6>
	<h5>
		Private instance variable -
		<%=mesg1%></h5>
	<h5>
		Local variable -
		<%=mesg2%></h5>
	<h5>Page scoped attribute - ${pageScope.nm}</h5>

</body>
</html>