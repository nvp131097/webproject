<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="register" method="post">
	<h3>Welcome to Register Page.....</h3>
		<label for="fname">First Name:</label><br>
		<input type="text" id="fname" name="fname" required="required"><br>
		
		<label for="lname">Last Name:</label><br>
		<input type="text" id="lname" name="lname" required="required"><br>
		
		<label for="email">Email:</label><br>
		<input type="text" id="email" name="mail" required="required"><br>
		
		<label for="uname">UserName:</label><br>
		<input type="text" id="uname" name="uname" required="required"><br>
		
		<label for="pass">Password:</label><br>
		<input type="password" id="pass" name="pass" required="required"><br>
		
		<label for="rpass">Re-Enter Password:</label><br>
		<input type="password" id="rpass" name="rpass" required="required"><br>
		
		<input type="radio" name="user_gender" value="male">Male<br>
		<input type="radio" name="user_gender" value="female">Female<br>
		
		<select name="user_course">
			<option value="java">Java</option>
			<option value="python">Python</option>
			<option value=".net">.Net</option>
			<option value="c">C</option>
			<option value="android">Android</option>
			<option value="php">Php</option>
		</select><br>
		<input type="checkbox" value="checked" name="condition"/>Agree terms and conditions<br>
		<input type="submit" value="Submit">
		<input type="reset" value="Reset">
		
	 </form>
</body>
</html>