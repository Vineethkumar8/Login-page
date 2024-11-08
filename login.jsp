<%-- 
    Document   : login
    Created on : 18 Oct, 2024, 11:33:13 AM
    Author     : sensen
--%>

<%@ page contentType="text/html" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body{
            background-color: wheat;
        }
        h2{
            text-align: center;
        }
        form {
            max-width: 300px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        button{
            margin-left: 100px;
        }
        
    </style>
</head>
<body>
    <h2>Login</h2>
    <form action="login" method="get">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="login">
        <button onclick="window.location.href='register.jsp';">Register New User</button>
    </form>
    
    
</body>
</html>
