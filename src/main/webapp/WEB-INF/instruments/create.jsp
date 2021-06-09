<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Create a post!" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />
<div class="container">
    <h1>Please fill in your information.</h1>
    <form action="/instruments/create" method="post">
        <div class="form-group">
            <label for="name">Instrument Name</label>
            <input id="name" name="name" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control"></textarea>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input id="price" name="price" type="number" min="0.00" max="10000.00" step="0.01">
        </div>
        <div class="form-group">
            <label for="paymentType">Payment Type</label>
            <select name="paymentType" id="paymentType">
                <option value="cash">Cash</option>
                <option value="card">Card</option>
            </select>
        </div>
        <div class="form-group">
            <label for="shippingMethod">Shipping method</label>
            <select name="shippingMethod" id="shippingMethod">
                <option value="pickup">Pickup</option>
                <option value="shipped">Shipped</option>
            </select>
        </div>
            <label>What type(s) of instrument are you posting?</label>
            <input type="checkbox" name="types" value="string">String<br>
            <input type="checkbox" name="types" value="woodwind">Woodwind<br>
            <input type="checkbox" name="types" value="brass">Brass<br>
            <input type="checkbox" name="types" value="percussion">Percussion<br>
            <input type="checkbox" name="types" value="electronic">Electronic<br>
            <input type="checkbox" name="types" value="plucked">Plucked<br>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>
</body>
</html>
