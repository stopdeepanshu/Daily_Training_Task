<html>

<body style="text-align: center; margin-top: 100px;">

	<h2>Login Page</h2>

	${msg}

	<form action="<%=request.getContextPath()%>/login" method="post">

		Username: <input type="text" name="username" /> <br>
		<br> Password: <input type="password" name="password" /> <br>
		<br> <input type="submit" value="Login" />

	</form>

</body>

</html>