<%@ page import="org.bugjlu.mycollection.po.User" %><%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 2017/10/22
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">

<%@ include file="../head.jsp" %>

<body class="body-my">

<nav class="navbar navbar-fixed-top navbar-default container-fluid navbar-my">
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
                <li><a href="my.html">我的</a></li>
                <li><a href="follow.html">关注</a></li>
                <%--<li><a href="hot.html">热门</a></li>--%>
                <%
                    if (request.getSession().getAttribute("user") == null) {
                %>
                <li>
                    <div style="padding: 9px">
                        <a href="login.html" class="btn btn-default btn-block btn-success">登录</a>
                    </div>
                </li>
                <li><a href="register.html">注册</a></li>
                <%
                } else {
                %>
                <li><a href="account.html">欢迎您，${user.userName}</a></li>
                <li><a href="logout.html">注销</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown">
                        +
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="searchuser.html">添加关注</a> </li>
                        <li><a href="my.html">添加内容</a> </li>
                    </ul>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>

<%
    User user = (User) request.getSession().getAttribute("user");
%>

<div class="simple-container">
    <h1>
        修改信息
    </h1>
    <div class="container info-box" style="width: 100%">
        <form class="form-horizontal" role="form" id="updateform" action="updateact.html" method="post">
            <div class="form-group">
                <label class="control-label" for="email">E-mail </label>
                <input class="form-control" id="email" type="text" readonly="readonly" value="<%=user.getEmail()%>">
            </div>
            <div class="form-group" >
                <label class="control-label" for="name">用户名 *</label>
                <input class="form-control" id="name" name="name" type="text" value="<%=user.getUserName()%>">
            </div>
            <%--<div class="form-group">--%>
                <%--<label class="control-label" for="password">密码 *</label>--%>
                <%--<input class="form-control" id="password" name="password" type="password">--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label class="control-label" for="cfmpassword">确认密码 *</label>--%>
                <%--<input class="form-control" id="cfmpassword" name="cfmpassword" type="password">--%>
            <%--</div>--%>
            <div class="form-group">
                <label class="control-label" for="name">性别</label>
                <div class="radio">
                    <label class="radio-inline">
                        <input type="radio" id="genderM" name="gender" value="M">
                        男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" id="genderF" name="gender" value="F">
                        女
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label" for="name">年龄</label>
                <input class="form-control" id="age" name="age" type="text">
            </div>
            <div class="form-group info-box" style="margin-bottom: 0px">
                <p id="warning" style="text-align: center; color: red">
                    ${errmsg}
                </p>
                <%--<p style="text-align: center; color: red">ID已被注册，请重试</p>--%>
                <button type="button" class="btn btn-default btn-primary" onclick="check()">修改信息</button>
            </div>
        </form>
    </div>
</div>

<script src="js/update.js"></script>

<script src="https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.min.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
