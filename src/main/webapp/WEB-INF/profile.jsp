<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/profile">${sessionScope.user.username}!</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/index">Buy</a></li>
            <li><a href="/instruments/create">Sell instrument</a> </li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container">
    <h1>Welcome, </h1>
</div>

</body>
</html>
