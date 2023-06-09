<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIGN PAGE</title>
<style type="text/css">
		

		#div1{
			margin: 0px auto 0px auto;
			width: fit-content;
			border: 3px solid darkred;
			padding: 20px;
		}
		h2{
			text-align: center;
		}
		form input{
			padding: 10px;
			
		}

	</style>
</head>
<body>

<%@ page import="java.sql.*" %>

<%
String name=request.getParameter("name");
String email=request.getParameter("email");
String password=request.getParameter("password");
String cpassword=request.getParameter("cpassword");
//out.println(name+","+email+","+password+","+cpassword);
try{
Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
Class.forName("com.mysql.cj.jdbc.Driver");
String conn_string="jdbc:mysql://localhost:3306/Student?"+"user=root&password=7261888792";
//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","7261888792");
conn=DriverManager.getConnection(conn_string);
stmt=conn.createStatement();
String query="insert into users(name,email,password,cpassword) values('"+name+"','"+email+"','"+password+"','"+cpassword+"')";
stmt.executeUpdate(query);
out.println("Executed Successfuly");
System.out.println("Executed Successfuly");

//rs.close();
//stmt.close();
//conn.close();
}catch(Exception e){
	out.println(e);
}

%>
<div id="div1">
		<h2>Sign IN</h2>

<form action="home.jsp" name="form">
 
  <label for="lname" id="lemail">Email:</label><br>
  <input type="text"  id="email" name="email" placeholder="Enter your email" size="40" > <br><br>
  
   <label for="lname" id="lpassword">Password:</label><br>
  <input type="text" id="password" name="password"  placeholder="Enter a strong password" size="40" ><br><br>
 
  
  <input type="submit" value="SIGN IN" style="width:100%" >
</form> 
		

	</div>


</body>
</html>