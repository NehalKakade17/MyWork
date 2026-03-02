<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%-- useBean JSP standard action --%>
<%-- creates bean instance if it doesn't exist --%>
<jsp:useBean id="user_bean" class="com.cdac.beans.UserBean" scope="session"/>
<%-- transfer email n password to bean --%>
<%--WC tries to call ALL MATCHING setters in the bean class --%>
<jsp:setProperty property="*" name="user_bean"/>

<body>
<%--how to invoke B.L method of bean without scriptlet ? EL syntax --%>
<%-- session.getAttribute("user_bean").validateUser() --%>
  <jsp:forward page="${sessionScope.user_bean.validateUser()}.jsp"/>
        
</body>
</html>