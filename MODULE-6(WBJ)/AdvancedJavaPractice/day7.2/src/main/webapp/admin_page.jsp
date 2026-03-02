<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h5 style="color: green;">${sessionScope.user_bean.message}</h5>
	<%-- Hello , user name n role --%>
	<h5>Hello , ${sessionScope.user_bean.userDetails.firstName}
		${sessionScope.user_bean.userDetails.lastName}</h5>
	<h5>You are currently logged in as
		${sessionScope.user_bean.userDetails.userRole}</h5>
</body>
</html>