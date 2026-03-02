<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="user" value="${sessionScope.user_details}" />
	<h5 align="center">${sessionScope.mesg}</h5>
	<h5>Hello ${user.role} , ${user.firstName} ${user.lastName}</h5>
	<h5>
		<c:url var="url" value="/user/logout" />
		<a href="${url}">Log Me Out</a>
	</h5>

</body>
</html>