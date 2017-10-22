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

<body class="body-my">

<link href="css/login&register.css" rel="stylesheet">

<div class="center-form container">
    <h3 style="text-align: center">
        <a class="autoheightbrand" href="index.html">收藏荚</a>
    </h3>
    <div class="container" style="width: 100%">
        <form class="form-horizontal" role="form" id="logform" action="loginact.html" method="post">
            <div class="form-group">
                <label class="control-label" for="email">E-mail</label>
                <input class="form-control" id="email" name="email" type="text">
            </div>
            <div class="form-group">
                <label class="control-label" for="password">密码</label>
                <input class="form-control" id="password" name="password" type="password">
            </div>
            <div class="form-group" style="margin-bottom: 0px">
                <p id="warning" style="text-align: center; color: red">
                    ${errmsg}
                </p>
                <button type="button" class="btn btn-default btn-success btn-block loginbutton" onclick="check()">登录</button>
            </div>
            <p style="text-align: center">
                忘记密码？<a href="forgetaccount.html">点此找回</a>
            </p>
            <hr color="#A0A0A0"/>
            <div class="form-group" style="width: auto; margin-bottom: 0px">
                <div class="pull-left">
                    <p class="form-control-static">还没有账号？</p>
                </div>
                <div class="pull-right">
                    <a href="register.html" class="btn btn-default">注册</a>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="js/login.js"></script>

<script src="https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.min.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
