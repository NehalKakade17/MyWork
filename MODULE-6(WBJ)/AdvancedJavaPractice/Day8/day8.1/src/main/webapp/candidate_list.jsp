<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- Hello , user name n role --%>
	<h5>Hello , ${sessionScope.user_bean.userDetails.firstName}
		${sessionScope.user_bean.userDetails.lastName}</h5>
	<h5>You are currently logged in as
		${sessionScope.user_bean.userDetails.userRole}</h5>
</body>
</html>