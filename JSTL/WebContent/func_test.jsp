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
<c:set var="name" value="my name is rashon"></c:set>

The length of name is : ${fn:length(name)}
<br>
Uppercase version of the string is: ${fn:toUpperCase(name)}
<br><br>
Does the string starts with<b>my</b> : ${fn:startsWith(name,"my") }
</body>
</html>