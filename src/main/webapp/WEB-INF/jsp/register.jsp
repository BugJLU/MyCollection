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

<%@ include file="head.jsp" %>

<body>

<div class="center-form container">
    <h3 style="text-align: center">
        <a class="autoheightbrand" href="index.html">MedicalSearch</a>
    </h3>
    <div class="container" style="width: 100%">
        <form class="form-horizontal" role="form" id="regform" action="regact.html" method="post">
            <div class="form-group">
                <label class="control-label" for="id">ID</label>
                <input class="form-control" id="id" name="id" type="text">
            </div>
            <div class="form-group">
                <label class="control-label" for="name">昵称</label>
                <input class="form-control" id="name" name="name" type="text">
            </div>
            <div class="form-group">
                <label class="control-label" for="passwd">密码</label>
                <input class="form-control" id="passwd" name="passwd" type="password">
            </div>
            <div class="form-group">
                <label class="control-label" for="cfmpasswd">确认密码</label>
                <input class="form-control" id="cfmpasswd" name="cfmpasswd" type="password">
            </div>
            <div class="form-group" style="margin-bottom: 0px">
                <p id="warning" style="text-align: center; color: red">
                    ${errmsg}
                </p>
                <%--<p style="text-align: center; color: red">ID已被注册，请重试</p>--%>
                <button type="button" class="btn btn-default btn-success btn-block mybutton" onclick="check()">注册</button>
            </div>
            <hr color="#A0A0A0"/>
            <div class="form-group" style="width: auto; margin-bottom: 0px">
                <div class="pull-left">
                    <p class="form-control-static">已有账号？</p>
                </div>
                <div class="pull-right">
                    <a href="login.html" class="btn btn-default">登录</a>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="js/registercheck.js"></script>

<script src="https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.min.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
