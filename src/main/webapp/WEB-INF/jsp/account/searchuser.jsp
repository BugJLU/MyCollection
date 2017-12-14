<%@ page import="java.util.List" %>
<%@ page import="org.bugjlu.mycollection.po.User" %>
<%--<%@ page import="java.net.URLDecoder" %>--%>
<%@ page import="java.net.URLEncoder" %>
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

<% String list = (String) request.getAttribute("list");%>

<link href="css/contentpage.css" rel="stylesheet">

<body onresize="changenav()" onload="changenav()" class="body-my">

<nav class="navbar navbar-fixed-top navbar-default container-fluid navbar-my">

    <div id="brand" class="navbar-brand collapse navbar-collapse autoheightbrand">
        <a  href="#" >收藏荚</a>
    </div>

    <div id="formdiv" class="nav navbar-nav navbar-left row formnav" style="padding: 9px; width: 100%">
        <form action="searchuser.html" method="get">
            <div class="row">
                <%
                    if (list == null) {
                %>
                <div class="col-xs-8">
                    <input type="text" name="skey" class="form-control" value="<%=request.getParameter("skey")==null?"":request.getParameter("skey")%>">
                </div>
                <div class="col-xs-2">
                    <input type="submit" class="btn btn-default btn-warning" style="right: 0px" value="搜索">
                </div>
                <%
                    } else {
                %>
                <div class="col-xs-10"></div>
                <%
                    }
                %>
                <div class="col-xs-2">
                    <button type="button" class="navbar-toggle mytoggle" data-toggle="collapse"
                            data-target="#navbar,#brand">
                        <span class="sr-only">切换导航</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
            </div>
        </form>
    </div>

    <div class="collapse navbar-collapse" id="navbar">
        <ul class="nav navbar-nav navbar-right">
            <%
                if (request.getSession().getAttribute("user") != null) {
            %>
            <li><a href="my.html">我的</a></li>
            <li><a href="follow.html">关注</a></li>
            <%
                }
            %>
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
                    <%
                        if (list == null) {
                    %>
                    <li class="active"><a href="#">添加关注</a> </li>
                    <%
                        } else {
                    %>
                    <li><a href="searchuser.html">添加关注</a> </li>
                    <%
                        }
                    %>
                    <li><a href="my.html">添加内容</a> </li>
                </ul>
            </li>
            <%
                }
            %>
        </ul>
    </div>
</nav>

<%
    if (list == null && request.getParameter("skey") == null) {
%>
<div class="maincontainer" id="maincontainer">
    <div class="nothingtoshow">
        <h2>搜索感兴趣的人并关注</h2>
    </div>
</div>
<%
    }
    else {
        List<User> result = (List<User>) request.getAttribute("result");
        if (result == null || result.size() == 0){
            if (list != null && list.equals("followee")){
%>
<div class="maincontainer" id="maincontainer">
    <div class="nothingtoshow">
        <h2>您还没有关注任何人哦！</h2>
        <h2>点击<a href="searchuser.html">添加关注</a></h2>
    </div>
</div>
<%
            } else {
%>
<div class="maincontainer" id="maincontainer">
    <div class="nothingtoshow">
        <h2>没有搜索结果</h2>
    </div>
</div>
<%
            }
        } else {
%>

<div class="resultcontent">
    <%
        if (list == null) {
    %>
    <div class="container">
        <p style="color: #5e5e5e">搜索到${result.size()}条数据</p>
    </div>
    <%
        }
        for (User u :
                result) {
    %>
    <div class="container">
        <a href="account.html?email=<%= URLEncoder.encode(u.getEmail(), "UTF-8") %>">
            <h3>
                <%=u.getUserName()%>
            </h3>
        </a>
        <p>
            E-mail: <%= u.getEmail() %>
        </p>
        <p>
            <% if (u.getBGender() != null) {
                out.print("性别："+(u.getBGender()?"男":"女"));
            }%>
        </p>
        <p>
            <% if (u.getAge() != null) {
                out.print("年龄："+u.getAge());
            }%>
        </p>
        <%--<a style="color: #3c763d" class="overflow" href="javascript:void(0)" onclick="clickres('<%=p.getPage().getId()%>')">--%>
            <%--<%--%>
                <%--String url = p.getPage().getUrl();--%>
                <%--if (url.length() > 50) {--%>
                    <%--url = url.substring(0, 50) + "...";--%>
                <%--}--%>
                <%--out.print(url);--%>
            <%--%>--%>
        <%--</a>--%>
        <hr color="#A0A0A0"/>
    </div>
    <%
                }
            }
        }
    %>
</div>

<%--<%@include file="hiddencards.jsp"%>--%>

<script src="js/searchuser.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
