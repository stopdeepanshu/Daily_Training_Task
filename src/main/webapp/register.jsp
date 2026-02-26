<html>
<body style="text-align: center; margin-top: 100px;">
	<h2>User Registration</h2>
	<form action="<%=request.getContextPath()%>/register" method="post">
		  Username: <input type="text" name="username" /> <br>
		<br> Password: <input type="password" name="password" /> <br>
		<br> <input type="submit" value="Register" />
	</form>
</body>
</html>