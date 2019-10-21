<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background:url(<%=basePath%>/resource_static/img/backgrounds/4.jpg);background-repeat: repeat;background-size: 100% 100%;">
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">HOME</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="activate"><a>BioInformatics</a></li>
                <li><a href="#">GAME</a></li>
                <li><a>BLOG</a></li>
                <li><a href="/mood/findAllForRedis">Mood</a> </li>
                <li class="dropdown" style="text-shadow: rgb(143, 108, 108) 1px 1px 1px;">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-music"></span> &nbsp;MUSIC <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">SONGS</a></li>
                        <li class="divider"></li>
                        <li><a href="#">SINGERS</a></li>
                        <li class="divider"></li>
                        <li><a href="#">MV</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Other</a></li>
                    </ul>
                </li>
                <c:if test="${nickname != null}">
                    <li class="dropdown" style="text-shadow: rgb(143, 108, 108) 1px 1px 1px;">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-user"></span>&nbsp;${nickname} <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/user/toRegister"><span class="glyphicon glyphicon-user"></span>Register</a> </li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${nickname == null}">
                    <li class="dropdown" style="text-shadow: rgb(143, 108, 108) 1px 1px 1px;">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-user"></span>&nbsp;USER <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="/user/toLogin"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Login</a></li>
                            <li class="divider"></li>
                            <li><a href="/user/toRegister"><span class="glyphicon glyphicon-user"></span>Register</a> </li>
                        </ul>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
