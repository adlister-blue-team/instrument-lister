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
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>Welcome Fellow Musician</h1>
    <form action="/login" method="POST">
        <h3>Please Login:</h3>
        <div class="form-group">
            <label for="username">Username:</label>
            <input id="username" name="username" class="form-control" type="text">
            <br>
            <br>
            <label for="password">Password:</label>
            <input id="password" name="password" class="form-control" type="password">
            <br>
            <br>
            <input type="submit" value="Log In">
            <p class="change_link">
                Not a member yet ?
                <a href="/register" class="to_register">Join us</a>
            </p>
        </div>
    </form>
</div>
</body>
</html>
