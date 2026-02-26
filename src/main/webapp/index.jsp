<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Welcome Learners from JSP!!</h1>
 <a href=<%= request.getContextPath() %>/home>Click here</a>
 
 <form action="<%= request.getContextPath() %>/login" method="post">
 username: <input type="text" placeholder="Enter  name" name="username"/> <br><br>
 pswd: <input type="password" placeholder="Enter password" name="password"/><br><br>
 
 <input type="submit" value="login"/>
 </form>
</body>
</html>