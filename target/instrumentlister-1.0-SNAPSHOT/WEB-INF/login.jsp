<%--
  Created by IntelliJ IDEA.
  User: vanessa
  Date: 6/4/21
  Time: 12:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

<div class="container">
    <h1>Welcome Fellow Musician</h1>
    <form action="/login" method="POST">
        <p>Login:</p>
        <div class="form-group">
            <label for="username">Username:</label>
            <input id="username" name="username" class="form-control" type="text">

            <label for="password">Password:</label>
            <input id="password" name="password" class="form-control" type="password">

        <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </div>
    </form>
</div>
</body>
</html>
