<%@page import="java.io.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.servlet.http.Part"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>this is what was found after inputing your image</h1><br><br>
<%
Part p= request.getPart("file");
InputStream st=p.getInputStream();
out.println(st.toString());
%>


</body>
</html>