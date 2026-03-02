<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%--import JSTL core tag library --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%-- create user bean n add it under session scope --%>
<jsp:useBean id="user_bean" class="com.cdac.beans.UserBean" scope="session"/>
<%--create candidate bean n add it under application scope --%>
<jsp:useBean id="candidate_bean" class="com.cdac.beans.CandidateBean" scope="application"/>
<%-- transfer email n password to bean --%>
<%--WC tries to call ALL MATCHING setters in the bean class --%>
<jsp:setProperty property="*" name="user_bean"/>

<body>
<%--how to invoke B.L method of bean without scriptlet ? EL syntax --%>
<%-- session.getAttribute("user_bean").validateUser() --%>
  <c:redirect url="${sessionScope.user_bean.validateUser()}.jsp"/>
        
</body>
</html>