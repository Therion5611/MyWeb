
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login");
        return;
    }
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home2</title>
    </head>
    <body>
        <h1>Greeting, ${sessionScope.username}</h1>
        <a href = "home.jsp">Return to home</a>
    </body>
</html>
