<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .button {
            background-color: #51515b;
            color: white;
            border: 2px #3775c5;
            margin: 2px;
            padding: 3px;
        }
    </style>
    <title>Login</title>
</head>
<body><center>
    <h3><%= "Sign in"%></h3>
    <form action="login" method="post">
        <fieldset>
            <h4>Enter username : <input type="text" name="user"><br><br>
                Enter password : <input type="password" name="pass"><br></h4>
                <h5><a href="">Forgot password?</a>&nbsp&nbsp
        <input type="submit" class="button" value="Login"></h5>
        </fieldset>
    </form>
    
</center>
</body>
</html>
