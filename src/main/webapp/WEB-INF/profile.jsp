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
            <a class="navbar-brand" href="/profile">${sessionScope.user.username}</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/instruments">Buy</a></li>
            <li><a href="/instruments/create">Sell instrument</a> </li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container">
</div>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container bootstrap snippets bootdey">
    <div class="row">
        <div class="profile-nav col-md-3">
            <div class="panel">
                <div class="user-heading round">
                    <a href="#">
                        <img src="" alt="Profile Image">
                    </a>
                    <h1>${sessionScope.user.username}</h1>
                    <p>${sessionScope.user.email}</p>
                </div>

                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="#"> <i class="fa fa-user"></i> Profile</a></li>
                    <li><a href="#"> <i class="fa fa-calendar"></i> Recent Activity <span class="label label-warning pull-right r-activity">9</span></a></li>
                    <li><a href="#"> <i class="fa fa-edit"></i> Edit profile</a></li>
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
            <div class="panel">
                <div class="bio-graph-heading">
                 User bio heading here!
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
    </div>
</div>
        </body>
</html>
