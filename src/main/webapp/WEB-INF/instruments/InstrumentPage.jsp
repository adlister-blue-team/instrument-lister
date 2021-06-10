<%@ page import="dao.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: victorhernandez
  Date: 6/7/21
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>
    <title>Instrument Page</title>
</head>
<body>
<jsp:include page="../partials/navbar.jsp"/>
<form action="/checkout" method="post">
    <h1>Here is your requested instrument:</h1>
    <h3>Name of instrument: <em>${SingleAd.name}</em></h3>
    <h3>Description: <em>${SingleAd.description}</em></h3>
    <h3>Owners Username: <em>${SingleAd.owner.username}</em></h3>
    <h3>Price: <em>${SingleAd.price}</em></h3>
    <h3>Shipping Method: <em>${SingleAd.shippingMethod}</em></h3>
    <input type="submit" value="Buy">
</form>
</body>
</html>
