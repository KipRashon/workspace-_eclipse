<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="theLocale"
	value="${not empty param.theLocale? param.theLocale:pageContext.request.locale }"
	scope="session"/>
	 
	<fmt:setLocale value="${theLocale}"/>
	<fmt:setBundle basename="resource.labels"/>


<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<a href="i18n.jsp?theLocale=en_US ">English(US)</a>
<a href="i18n.jsp?theLocale=es_ES">Spanish(ES)</a>
<a href="i18n.jsp?theLocale=de_DE ">German(DE)</a>
<br>
<fmt:message key="label.greeting"></fmt:message><br><br>
<fmt:message key="label.firstName"></fmt:message><i>Kiptoo</i><br><br>
<fmt:message key="label.lastName"></fmt:message><i>Rashon</i><br><br>
<fmt:message key="label.welcome"></fmt:message><br><br>
</body>
</html>