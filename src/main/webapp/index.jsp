<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%
    if (session.getAttribute("username")==null){
        response.sendRedirect("login.jsp");
    }
%>--%>
<% response.sendRedirect("items.jsp"); %>
<!DOCTYPE html>
<html>
<head>
    <title>Webb-shop</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>