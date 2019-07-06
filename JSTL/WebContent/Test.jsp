<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="time" value="<%= new java.util.Date() %>"></c:set>
The time on the server is ${time}
<br><br>
<%
String mycities[]={"Mogonjet","Chongenwo","Ruseya","Chebirbelek"};
//request.setAttribute("mycities", mycities);
%>
<c:forEach var="thecity" items="<%= mycities %>" >
${thecity}<br>
</c:forEach>

<sql:setDataSource driver="com.jdbc.mysql.Driver" password="kiptoo" 
url="jdbc:mysql://localhost:3306/mine" dataSource="user"
/>
<sql:query var="result">select * from user</sql:query>
<c:out value="${result }"></c:out>
</body>
</html>