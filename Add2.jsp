<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUM OF TWO NUMBER</title>
</head>
<body>
<h1>THE SUM OF TWO NUMBER</h1>
<%
  try{
     int a=Integer.parseInt(request.getParameter("num1"));
     int b=Integer.parseInt(request.getParameter("num2"));
  	 out.println("<h1>THE SUM:"+(a+b)+"</h1>"); 
  }catch(Exception e){
	  out.println(e);
  }
 %>

</body>
</html>