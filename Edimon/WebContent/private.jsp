<%@page import="code1.userBean"%>
<html>
<title>
www.trial.com</title>
<body>
<style>
body{
background-color: white;
color:purple;
}
h1{
background-color:blue;
color:white;}
</style>
<h1>JUST TRYING</h1>
<p> YOU ALWAYS LOOK WOW. I REALLY LOVE IT</p>
<p>
<%
userBean us= (userBean)request.getAttribute("user");
String username=us.getUsername();
String password=us.getPassword();

%>

<form action="Private" method="post" enctype="multipart/form-data">
Please upload your passport sized photo.<br />
<input type="file" name="file"><br />



<%--Trying to prepopulate the form  name field --%>


<fieldset> 
<legend> PERSONAL DETAILS</legend>

Username:
<input type="text" name="name" size="30"  value="<%= username %>"  disabled="disabled">
<%--
password:
<input type="password" name="password" size="6" required="required"> --%>
Email:
<input type="email" name="email" size="20" required="required"/><br />
You are <label>
<input type="radio" name="you" value="STUDENT"/> STUDENT
</label>
<label>
<input type="radio" name="you" value="STAFF"/> STAFF
</label><br />
<label>
<input type="radio" name="you" value="ALUMNI"/> ALUMNI
</label><br />
if student which year are you?<br />
<label >
<input type="radio" name="year" value="one"/> 1<sup>st</sup> year
</label><br />
<label>
<input type="radio" name="year" value="two"/> 2<sup>nd</sup> year
</label><br />
<label>
<input type="radio" name="year" value="three"/> 3<sup>rd</sup> year
</label><br />
<label>
<input type="radio" name="year" value="four"/> 4<sup>th</sup> year
</label><br />
<label>
<input type="radio" name="year" value="five"/> 5<sup>th</sup> year
</label><br />
<label>
<input type="radio" name="year" value="other"/> others
</label>
<label>
<p>Religion:
<select name="religion">
<option value="SDA"> SDA</option>
<option value="catholic"> CATHOLIC</option>
<option value="muslim"> MUSLIM</option>
<option value="others"> others </option>
</select>
<p>
if others please specify
<textarea name="religion" col="10" rows="6"></textarea><br />
</p>
<p> Which course are you taking?
<label>
<input type="text" size="20" name="course"/></label>
</p>
</label>
</fieldset>
<fieldset>
<legend>CHURCH</legend>

Do you like attending church?<br />
<label><input type="radio" name="attend" value="yes" > Yes
<br />
</label>
<label>
<input type="radio" name="attend" value="no" > No
</label><br />
<label>
if yes, why do you like attending?<br />
<input type="checkbox" name="reason" value="love" > God's love
</label><br />
<label>
<input type="checkbox" name="reason" value="time" > just to pass time
</label><br />
<label>
<input type="checkbox" name="reason" value="peer" > peer influence
</label><br />
<label>
<input type="checkbox" name="reason" value="parents" > force from parents
</label><br />
<label>
<input type="checkbox" name="reason" value="others" > others(please state) 
</label><br />
<textarea name="coments" col="15" rows="5"></textarea>
</fieldset>
<input type="submit" value ="upload"/>
</form>
</body>
</html>