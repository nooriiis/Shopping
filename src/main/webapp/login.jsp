<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body><center>
    <h3><%= "Sign in"%></h3>
    <form action="login" method="post">
        <fieldset>
        Enter username : <input type="text" name="user"><br><br>
        Enter password : <input type="password" name="pass"><br><br>
        <a href="">Forgot password?</a>
        <input type="submit" value="Login">
        </fieldset>
    </form>
</center>
</body>
</html>
