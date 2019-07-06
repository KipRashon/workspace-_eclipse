<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="code1.loginuser" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- need to create the methods to get the values of the stuff that were passed from the request --%>
<%
loginuser user=(loginuser)request.getAttribute("user");
%>
<h1>Hello user welcome to our page </h1>
<h4>Your details are as follows: </h4>
<ul>
Firstname: <li><%= user.getFname() %></li>
Lastname: <li><%= user.getLname() %></li>
Password: <li><%= user.getPassword() %></li>
</ul>
</body>
</html>