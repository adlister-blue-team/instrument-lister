<%--
  Created by IntelliJ IDEA.
  User: irfasheikh
  Date: 6/7/21
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Shopping Cart" />
    </jsp:include>
</head>
<body>

<div class="container">
    <h1>Checkout Information</h1>
    <form action="/welcome" method="post">
        <div class="Billing Address">
            <label for="address">Billing Address</label>
            <input id="address" name="address" type="text">
        </div>

        <div class="Shipping Address">
            <label for="shippingAddy">Shipping Address</label>
            <input id ="shippingAddy" name="shipping" type="text">
        </div>

        <div class="Card Payment">
            <label for="cardpay">Card Information</label>
            <input id="cardpay" name="cardpay" type="text">
                   <button type="submit">Complete your purchase!</button>

        </div>
    </form>

</div>
</body>
</html>
