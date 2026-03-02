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
	<!-- Access the request-scoped attribute mesg1 -->
    <h5>Private instance variable (from request) - <%= request.getAttribute("mesg1") %></h5> <!-- Accesses mesg1 via request scope -->
    
    <!-- Access the request-scoped attribute mesg2 -->
    <h5>Request scoped attribute (mesg2) - <%= request.getAttribute("mesg2") %></h5> <!-- mesg2 is available from request scope -->
    
    <!-- Access the page-scoped attribute nm -->
    <h5>Page scoped attribute (nm) - ${pageScope.nm}</h5> <!-- nm is available via page scope -->

</body>
</html>