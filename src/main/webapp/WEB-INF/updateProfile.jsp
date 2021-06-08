<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kelvon
  Date: 6/8/21
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Edit Profile" />
    </jsp:include>
    <title>Edit Profile</title></head>
<body>
<h2>Update your profile</h2>
<div class="form">
    <form action="/updateProfile" method="post">
        <input type="text" name="username" placeholder="${sessionScope.user.username}" value="${sessionScope.user.username}">
        <input type="email" name="Email_Address" placeholder="${sessionScope.user.email}" value="${sessionScope.user.email}">
        <input type="text" name="First_Name" placeholder="First Name" value="${sessionScope.user.firstName}">
        <input type="text" name="Last_Name" placeholder="${sessionScope.user.lastName}">
        <input class="button" type="submit">
    </form>
</div>
</body>
</html>
