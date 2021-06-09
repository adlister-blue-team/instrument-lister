<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <link rel="stylesheet" href="/css/user_profile-view.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/profile">${sessionScope.user.username}</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/instruments">Buy</a></li>
            <li><a href="/instruments/create">Sell instrument</a> </li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<section class="profile">
    <header class="header">
        <div class="details">
            <img src="https://images.unsplash.com/photo-1517365830460-955ce3ccd263?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ&s=b38c22a46932485790a3f52c61fcbe5a" alt="John Doe" class="profile-pic">
            <h1 class="heading">${sessionScope.user.username}</h1>
            <div class="location">
<%--                <svg width="18" height="18" viewBox="0 0 24 24" fill="currentColor">--%>
<%--                    <path d="M12,11.5A2.5,2.5 0 0,1 9.5,9A2.5,2.5 0 0,1 12,6.5A2.5,2.5 0 0,1 14.5,9A2.5,2.5 0 0,1 12,11.5M12,2A7,7 0 0,0 5,9C5,14.25 12,22 12,22C12,22 19,14.25 19,9A7,7 0 0,0 12 ,2Z"></path>--%>
<%--                </svg>--%>
                <p>${sessionScope.user.email}</p>
            </div>
            <div class="stats">
                <div class="col-4">
                    <h4>20</h4>
                    <p>Reviews</p>
                </div>
                <div class="col-4">
                    <h4>10</h4>
                    <p>Instruments</p>
                </div>
                <div class="col-4">
                    <h4>100</h4>
                    <p>Sold</p>
                </div>
            </div>
        </div>
    </header>
</section>
<div class="container">
</div>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container bootstrap snippets bootdey">
    <div class="row">
        <div class="profile-nav col-md-3">
            <div class="panel">

                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="#"> <i class="fa fa-user"></i> Profile</a></li>
                    <li><a href="/updateProfile"> <i class="fa fa-edit"></i> Edit profile</a></li>
                </ul>
                <a href="/deleteUser/${sessionScope.user.username}">Delete Profile</a>
            </div>
        </div>
        <div class="profile-info col-md-9">
            <div class="panel">
                <footer class="panel-footer">
                    <button class="btn btn-warning pull-right">Post</button>
                    <ul class="nav nav-pills">
                        <li>
                            <a href="#"><i class="fa fa-map-marker"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-camera"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class=" fa fa-film"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-microphone"></i></a>
                        </li>
                    </ul>
                </footer>
            </div>
                <div class="panel-body bio-graph-info">
                    <h1>Bio Graph</h1>
                    <div class="row">
                        <div class="bio-row">
                            <p><span>First Name </span>: ${sessionScope.user.firstName}</p>
                        </div>
                        <div class="bio-row">
                            <p><span>Last Name </span>: ${sessionScope.user.lastName}</p>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <c:forEach var="instrument" items="${sessionScope.user.instruments}">
        <div class="col-md-6">
            <h2>${instrument.name}</h2>
            <p>${instrument.description}</p>
            <p>${instrument.price}</p>
        </div>
         </c:forEach>
    </div>

    <script>

    </script>
        </body>
</html>
