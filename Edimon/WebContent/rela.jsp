<html>
<title> relationship</title>
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
<form action="rel" method="post">
<h1>YOUR RELATIONSHIP STATUS</h1>
<fieldset><legend>PAST</legend>
Have you ever been in a relationship?
<input type="radio" name="been" value="yes"> Yes
<input type="radio" name="been" value="no"> No<br />
Do you think it is important to be in a relationship?
<input type="radio" name="imp" value="yes"> Yes
<input type="radio" name="imp" value="no"> No<br />
Please give reasons for you answer above.<br />
<textarea name="yes" col="30" rows="12"></textarea><br/>
</fieldset>
<fieldset><legend>CURRENT</legend>
Are you currently in a relationship?
<input type="radio" name="current" value="yes"> Yes
<input type="radio" name="current" value="no"> No<br />
If no, are you thinking of being in one in the future?
<input type="radio" name="future" value="yes"> Yes
<input type="radio" name="future" value="no"> No<br />
</fieldset>
<fieldset><legend>VIEWS</legend>
What is your view about matters concerning relationship?<br />
<textarea name="views" col="30" rows="12"></textarea><input type="submit" name="submit" value="submit"/>
</fieldset>
</form>
</html>