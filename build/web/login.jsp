
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <h1>Login</h1>
        <p style="color: red;">${requestScope.errMsg}</p>
        <form action="login" method="POST" autocomplete="OFF">
            Username: <input type="text" name="username" value="${username}" required/><br>
            Password: <input type="password" name="password" value="${password}" required/><br>
            <input type="checkbox" name="rememberMe" value="ON" ${not empty password ? 'checked' : ''}/> Remember password <br>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
