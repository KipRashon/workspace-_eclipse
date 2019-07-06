<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,code1.Student" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Student> data= new ArrayList<>();
data.add(new Student("Kiptoo","Rashon",false));
data.add(new Student("John","Digo",true));
data.add(new Student("Theo","Queen",false));
data.add(new Student("Felicity","Smoke",true));
request.setAttribute("students", data);
%>
<table border="1">
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Gold Customer</th>
</tr>

<c:forEach var="thestudent" items="${students}">
			<tr>
			<td>${thestudent.firstName} </td> 
			<td>${thestudent.lastName}</td>  
			<td>
			<%-- 
				<c:if test="${thestudent.goldCustomer}">Special discount for you</c:if>
			  <c:if test="${not thestudent.goldCustomer}">You aint a gold customer</c:if>
			  --%>
			  <c:choose>
			  <c:when test="${thestudent.goldCustomer}">Special discount</c:when>
			  <c:otherwise>
			  No soup for you 
			  </c:otherwise>
			  </c:choose>
			</td>
			<tr>
</c:forEach>
</table>
</body>
</html>