<%--
  Created by IntelliJ IDEA.
  User: Kelvon
  Date: 6/4/21
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/profile">${sessionScope.user.username}</a>
        </div>
        <form class="form-inline" action="/searchInstruments" method="GET">
            <input class="form-control mr-0-sm-2" type="search" placeholder="Search" aria-label="Search" name="name">
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/welcome">Home</a></li>
            <li><a href="/profile">Profile</a></li>
            <li><a href="/instruments">Buy Instrument</a></li>
            <li><a href="/profile">Sell Your Instrument</a></li>
        </ul>
        </form>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

