<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Welcome Page" />
    </jsp:include>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">--%>
    <link rel="stylesheet" type=text/css href="/css/welcomePage.css">
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<main class="container">
    <header class="header jumbotron px-0 mt-5 d-none d-md-block">
        <h1 class="text-center bg-light">Welcome to the Blue Sounds Instrument Lister</h1>
    </header>
<br>
<h3 class="welcome-content">
    We are a small business with a large passion for creating music! We love to give our members the opportunity to explore different types of instruments by connecting them with musicians from around the world. Whether you are trying to enhance or reduce your instrument collection, our Instrument Lister can assist you in the process!
</h3>
<br>
</main>
</body>
</html>
