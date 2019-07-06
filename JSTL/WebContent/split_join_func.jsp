<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="names" value="Tokyo,Mumbai,Philadelphia,Nairobi,Cairo"></c:set>
Before splitting:
<c:out value="${names}"></c:out>
<br>
After splitting<br>
<c:set var="cities" value="${fn:split(names,',')}"></c:set>
<c:forEach var="city" items="${cities}">
	${city}<br>
</c:forEach>

After rejoining
<c:out value="${fn:join(cities,'--') }"></c:out>
</body>
</html>