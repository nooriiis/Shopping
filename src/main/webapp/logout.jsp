<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Logout</title>
</head>
<body>
<%
  if (session.getAttribute("username") != null){
    session.invalidate();
    response.sendRedirect("items.jsp");
  }
%>
</body>
</html>
