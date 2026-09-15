
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
        <title>Home Page</title>
    </head>
    <body>
        <h1>Hello, ${sessionScope.username}</h1> <br>
        <a href = "logout">Log out</a> <a href = "home2.jsp">Home2</a>
        
    </body>
</html>
