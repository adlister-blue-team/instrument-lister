<%--
  Created by IntelliJ IDEA.
  User: vanessa
  Date: 6/4/21
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>

    <title>Welcome Page</title>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<jsp:include page="partials/css/welcomePage.css"/>

<h1>Welcome to the Blue Sounds Instrument Lister</h1>
<h3>
    We are a small business with a large passion for creating music! We love to give our members the opportunity to explore different types of instruments by connecting them with musicians from around the world. Whether you are trying to enhance or reduce your instrument collection, our Instrument Lister can assist you in the process!
</h3>
<br>
<br>
<h4>
    What brings you to our site today?<br>
    I would like to browse the current listings<br>
    I would like to sell my instrument

</h4>
</body>
</html>
