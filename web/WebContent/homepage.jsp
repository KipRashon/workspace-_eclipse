<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ResultSet rs=(ResultSet) request.getAttribute("feeds");
while(rs.next()){
	%>
<h1><%= rs.getString("description") %></h1>	
	
	
	<%
}
%>
</body>
</html>