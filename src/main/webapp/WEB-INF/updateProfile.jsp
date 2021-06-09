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
<style>
    body{
        margin-top:20px;
            min-height: 60vh;
            background: #009FFF;
            background: linear-gradient(to right, #ec2F4B, #009FFF);
            color: white;
            clip-path: ellipse(100vw 60vh at 50% 50%);

        }

</style>
<body>
<h2>Update your profile</h2>


        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <div class="container">
            <div class="row flex-lg-nowrap">
                <div class="col-12 col-lg-auto mb-3" style="width: 200px;">
                    <div class="card p-3">
                    </div>
                </div>

                <div class="col">
                    <div class="row">
                        <div class="col mb-3">
                            <div class="card">
                                <div class="card-body">
                                    <div class="e-profile">
                                        <div class="row">
                                            <div class="col-12 col-sm-auto mb-3">
                                                <div class="mx-auto" style="width: 140px;">
                                                    <div class="d-flex justify-content-center align-items-center rounded" style="height: 140px; background-color: rgb(233, 236, 239);">
                                                        <span style="color: rgb(166, 168, 170); font: bold 8pt Arial;">140x140</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col d-flex flex-column flex-sm-row justify-content-between mb-3">
                                                <div class="text-center text-sm-left mb-2 mb-sm-0">
                                                    <h4 class="pt-sm-2 pb-1 mb-0 text-nowrap">${sessionScope.user.firstName} ${sessionScope.user.lastName} </h4>
                                                    <p class="mb-0">${sessionScope.user.email}</p>
                                                    <div class="mt-2">
                                                        <button class="btn btn-primary" type="button">
                                                            <i class="fa fa-fw fa-camera"></i>
                                                            <span>Change Photo</span>
                                                        </button>
                                                    </div>
                                                </div>
                                                <div class="text-center text-sm-right">
                                                    <span class="badge badge-secondary">User</span>
<%--                                                    <div class="text-muted"><small>Joined 09 Dec 2017</small></div>--%>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="tab-content pt-3">
                                                <form class="form" action="/updateProfile" method="post">
                                                    <div class="row">
                                                        <div class="col">
                                                            <div class="row">
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <label>First Name</label>
                                                                        <input class="form-control" type="text" name="firstName" placeholder="${sessionScope.user.firstName}" value="${sessionScope.user.firstName}">
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label>Last Name</label>
                                                                        <input class="form-control" type="text" name="lastName" placeholder="${sessionScope.user.lastName}" value="${sessionScope.user.lastName}">
                                                                    </div>
                                                                </div>
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <label>Username</label><input class="form-control" type="text" name="username" placeholder="${sessionScope.user.username}" value="${sessionScope.user.username}">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <label>Email</label>
                                                                        <input class="form-control" type="email" placeholder="${sessionScope.user.email}" value="${sessionScope.user.email}" name="email">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col mb-3">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-12 col-sm-6 mb-3">
                                                            <div class="mb-2 mr-2"><b>Change Password</b></div>
                                                            <div class="row">
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <label>Current Password</label>
                                                                        <input class="form-control" type="password" placeholder="••••••">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <label>New Password</label>
                                                                        <input class="form-control" type="password" placeholder="••••••">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col">
                                                                    <div class="form-group">
                                                                        <label>Confirm <span class="d-none d-xl-inline">Password</span></label>
                                                                        <input class="form-control" type="password" placeholder="••••••"></div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-12 col-sm-5 offset-sm-1 mb-3">
                                                            <div class="mb-2"><b>Keeping in Touch</b></div>
                                                            <div class="row">
                                                                <div class="col">
                                                                    <label>Email Notifications</label>
                                                                    <div class="custom-controls-stacked px-2">
                                                                        <div class="custom-control custom-checkbox">
                                                                            <input type="checkbox" class="custom-control-input" id="notifications-blog" checked="">
                                                                            <label class="custom-control-label" for="notifications-blog">Blog posts</label>
                                                                        </div>
                                                                        <div class="custom-control custom-checkbox">
                                                                            <input type="checkbox" class="custom-control-input" id="notifications-news" checked="">
                                                                            <label class="custom-control-label" for="notifications-news">Newsletter</label>
                                                                        </div>
                                                                        <div class="custom-control custom-checkbox">
                                                                            <input type="checkbox" class="custom-control-input" id="notifications-offers" checked="">
                                                                            <label class="custom-control-label" for="notifications-offers">Personal Offers</label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col d-flex justify-content-end">
                                                            <button class="btn btn-primary" type="submit">Save Changes</button> </div>
                                                        </div>
                                                </form>
                                        </div>
                                    </div>
                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-md-3 mb-3">
                            <div class="card mb-3">
                                <div class="card-body text-dark">
                                    <div class="px-xl-3">
                                        <form action="/logout" method="get">
                                        <button class="btn btn-block btn-secondary">
                                            <i class="fa fa-sign-out "></i>
                                            <span>Logout</span>
                                        </button></form>
                                    </div>
                                </div>
                            </div>
                        </div>
</body>
</html>
