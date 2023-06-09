<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP IN JAVA</title>
</head>
<body>

<h2>SIMPLE FORM</h2>

<form action="LoginServlet1" method="get" name="loginForm">
  <label for="userName">USER NAME:</label><br>
  <input type="text" id="username" name="username" placeholder="USER NAME"><br>
  <label for="userPassword">PASSWORD:</label><br>
  <input type="text" id="password" name="password" placeholder="Password"><br><br>
  <input type="submit" value="login"> <input type="reset">
</form> 

</body>
</html>