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
	<h5 style="color: green;">${sessionScope.user_bean.message}</h5>
	<%-- Hello , user name n role --%>
	<c:set var="user_dtls" value="${sessionScope.user_bean.userDetails}" />
	<h5>Hello , ${user_dtls.firstName} ${user_dtls.lastName}</h5>
	<h5>You are currently logged in as ${user_dtls.userRole}</h5>
	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>Top 2 Candidates</caption>
		<tr>
			<th>Candidate Name</th>
			<th>Candidate's Party Name</th>
			<th>Candidate Votes</th>
		</tr>
		<c:forEach var="candidate"
			items="${applicationScope.candidate_bean.candidates}">
			<tr>
				<td>${candidate.name}</td>
				<td>${candidate.partyName}</td>
				<td>${candidate.votes}</td>
			</tr>
		</c:forEach>
	</table>
	<h5>Top 2 Candidates -</h5>
</body>
</html>