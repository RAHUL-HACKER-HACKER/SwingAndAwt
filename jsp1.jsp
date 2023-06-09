<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VOLUME CALCULATED:</title>
</head>
<body>
<%
if(!(request.getParameter("length")=="" || request.getParameter("breath")=="" || request.getParameter("height")=="")){
  try{
     double a=Double.parseDouble(request.getParameter("length"));
     double b=Double.parseDouble(request.getParameter("breath"));
     double c=Double.parseDouble(request.getParameter("height"));
  	 out.println("<h1>VOLUME:"+(a*b*c)+"</h1>"); 
  }catch(Exception e){
	  out.println(e);
  }
  
}else{
	out.println("<p style='color:red;font-size:50px;'>Enter valid input</p>");
}
 %>
 <input type="button" value="BACK" onclick="window.location.href='html1.html'" style="height:50px;width:100px">
 
 <a href="html1.html">
    <button style="height:50px;width:100px"><b>EXIT</b></button>
  </a>
  
  <form action="html1.html">
  <input type="submit" value="BACK-2" style="height:50px;width:100px">
  </form>
  
</body>
</html>