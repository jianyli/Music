<%--
  Created by IntelliJ IDEA.
  User: li
  Date: 2019/10/6
  Time: 下午10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>

    <meta charset="utf-8">
    <title>Fullscreen Responsive Register Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
    <link rel="stylesheet" href="<%=basePath%>/resource_static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>/resource_static/css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>

<div class="header">
    <div class="container">
        <div class="row">
            <div class="logo span4">
                <h1><a href="">Register <span class="red">.</span></a></h1>
            </div>
            <div class="links span8">
                <a class="home" href="/index" rel="tooltip" data-placement="bottom" data-original-title="Home"></a>
                <a class="blog" href="/user/toRegister" rel="tooltip" data-placement="bottom" data-original-title="Register"></a>
            </div>
        </div>
    </div>
</div>

<div class="register-container container">
    <div class="row">
        <div class="iphone span5">
            <img src="<%=basePath%>/resource_static/img/time.jpg" alt="">
        </div>
        <div class="register span6">
            <form action="/user/login" method="post">
                <h2>REGISTER TO <span class="red"><strong>WebSite</strong></span></h2>
                <label for="username">username</label>
                <input type="text" id="username" name="username" placeholder="enter your username...">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="enter a password...">
                <button type="submit">LOGIN</button>
            </form>
        </div>
    </div>
</div>
<c:if test="${errorMsg != null}">

</c:if>
<!-- Javascript -->
<script src="<%=basePath%>/resource_static/js/jquery-1.8.2.min.js"></script>
<script src="<%=basePath%>/resource_static/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/resource_static/js/jquery.backstretch.min.js"></script>
<script src="<%=basePath%>/resource_static/js/scripts_login.js"></script>

</body>
</html>
