<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="green">
<%--create the table containing the  login page here --%>
<form action="login" method="post">
<table bgcolor="orange">

<tr>
<td>First Name</td>
<td><input type="text" name="fname"></td>
<td></td>

</tr>

<tr>
<td>Last Name</td>
<td><input type="text" name="lname"></td>
<td></td>

</tr>

<tr>
<td>Password </td>
<td><input type="password" name="password"></td>
<td></td>

</tr>

<tr>
<td></td>
<td><input type="submit" value="Login"></td>
<td></td>

</tr>
<tr>

<td>Don't have an account yet click register</td>
<td><a href="Register.jsp">REGISTER</a></td>
</tr>
</table>
</form>
</body>
</html>