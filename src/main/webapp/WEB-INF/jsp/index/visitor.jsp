<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2017/10/6
  Time: 下午6:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">

<%@ include file="../head.jsp" %>

<link href="css/login&register.css" rel="stylesheet">

<body>
<nav class="navbar navbar-fixed-top navbar-default container-fluid">
    <div>
        <div class="navbar-header">
            <a href="#" class="navbar-brand">收藏荚</a>
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#navbar">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <%--<li class="active"><a href="#">我的</a></li>--%>
                <%--<li><a href="follow.html">关注</a></li>--%>
                <%--<li><a href="hot.html">热门</a></li>--%>
                <%--<%--%>
                    <%--if (request.getSession().getAttribute("user") == null) {--%>
                <%--%>--%>
                <li>
                    <div style="padding: 9px">
                        <a href="login.html" class="btn btn-default btn-block btn-success">登录</a>
                    </div>
                </li>
                <li><a href="register.html">注册</a></li>
                <%--<%--%>
                <%--} else {--%>
                <%--%>--%>
                <%--<li><a>欢迎您，${user.userName}</a></li>--%>
                <%--<li><a href="logout.html">注销</a></li>--%>
                <%--<%--%>
                    <%--}--%>
                <%--%>--%>
            </ul>
        </div>
    </div>
</nav>

<div class="container" style="padding-top: 200px">
    <h1 style="text-align: center">
        欢迎使用收藏荚！
    </h1>
    <div class="row container dualbutton">
        <div class="col-xs-4">
            <a class="btn btn-default btn-success loginbutton center-block" href="login.html">登录</a>
        </div>
        <div class="col-xs-4"></div>
        <div class="col-xs-4">
            <a class="btn btn-default loginbutton center-block" href="register.html">注册</a>
        </div>
    </div>


</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
