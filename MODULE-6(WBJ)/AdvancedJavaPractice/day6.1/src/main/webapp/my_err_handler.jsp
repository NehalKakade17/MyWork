<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5 style="color: red;">Exception Message - <%= exception.getMessage() %></h5>
<h5 style="color: red;">Exception  - <%= exception %></h5>
<hr/>
	<h4 align="center">Via EL syntax</h4>
	<%-- pageContext.getException().getMessage() --%>
<h5 style="color: red;">Exception Message - ${pageContext.exception.message} </h5>
<h5 style="color: red;">Exception  - ${pageContext.exception} </h5>
<h5 style="color: red;">URI of error causing page   - ${pageContext.errorData.requestURI} </h5>
<h5 style="color: red;">Error Code   - ${pageContext.errorData.statusCode} </h5>

</body>
</html>