<%@ page import="java.net.URLEncoder" %><%--
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
                <li><a href="#">欢迎您，${user.userName}</a></li>
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
    String email = request.getParameter("email");
    if(email == null)
    {
%>

<div>
    <a href="/updateinfo.html">修改</a>
</div>
<%
}else{
%>
<div>
    <a href="/followuser.html?email=<%= URLEncoder.encode(email,"UTF-8") %>">关注</a>
</div>
<%
    }
%>

<div align="center">
        <div >
            <label class="">邮箱</label>
            <input id="email" class="" type="email" required="required" disabled="" value="111" style="border:none;background-color:white;"/>
        </div>
        <div>
            <label class="">昵称</label>
            <input id="username" class="" type="email" required="required" disabled="" />
        </div>
        <div>
            <label class="">年龄</label>
            <input id="age" class="" type="email" required="required" disabled="" />
        </div>

        <div>
            <label class="">性别</label>
            <label class="">女</label><input type="radio" name="sex" id="female"/>
            <label class="">男</label><input type="radio" name="sex" id="male"/>
        </div>
</div>

<script>
    function switch()
    {
        var button = document.getElementById("switch");
            if(button.value == "修改")
            {
                //跳转到修改界面
            }
            if(button.value == "关注")
            {
                //进行关注操作
                button.style.backgroundColor = "grey";
            }
    }
</script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
