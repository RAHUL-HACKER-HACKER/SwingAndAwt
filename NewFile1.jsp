<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%! int count=0; %>
</head>
<body>

<h1>Hello,<%= request.getParameter("name") %>!</h1>
<% out.println(++count); %>
</body>
</html>