<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Browsing Instruments" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>Checkout these instruments!</h1>

    <c:forEach var="instrument" items="${instruments}">
        <div class="col-md-6">
            <h2>${instrument.name}</h2>
            <p>${instrument.description}</p>
            <p>${instrument.ownerUsername}</p>
            <p>${instrument.price}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>
