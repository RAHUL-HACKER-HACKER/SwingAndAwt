<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add two Number</title>
</head>
<body>
<h1>THE SUM OF TWO NUMBER</h1>
<form action="Add2.jsp" method="get" name="add">
  <label for="num1">Enter 1st No:</label><br>
  <input type="number" id="num1" name="num1" ><br>
  <label for="num2">Enter 2st No::</label><br>
  <input type="number" id="num2" name="num2" ><br><br>
  <input type="submit" value="Cal Sum"> <input type="reset">
</form>
 
  <%--
  <%
  try{
     int a=Integer.parseInt(request.getParameter("num1"));
     int b=Integer.parseInt(request.getParameter("num2"));
  	 out.println("<h1>the Sum :"+(a+b)+"</h1"); 
  }catch(Exception e){
	  out.println(e);
  }
  %>
  --%>
  
</body>
</html>