<%@ page import="org.bugjlu.mycollection.web.vo.ContentVo" %>
<%@ page import="java.util.List" %>
<%@ page import="org.bugjlu.mycollection.po.Tag" %>
<%@ page import="org.bugjlu.mycollection.po.Content" %><%--
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

<link href="css/contentpage.css" rel="stylesheet">

<body onresize="resize()" onload="resize()" class="body-my">
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
                <%
                    if (request.getSession().getAttribute("user") != null) {
                %>
                <li class="active"><a href="index.html">我的</a></li>
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
                        <li><a href="searchuser.html">添加关注</a> </li>
                        <li><a href="javascript:void(0);" onclick="addContent()">添加内容</a> </li>
                        <li><a href="export.html" target="_blank">导出</a></li>
                        <li><a href="javascript:void(0);" onclick="uploadImport()">导入</a> </li>
                    </ul>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>

<div class="maincontainer row" id="maincontainer">
    <%
        List<ContentVo> contents = (List<ContentVo>) request.getAttribute("contents");
        if (contents == null || contents.size() == 0) {
    %>
    <div class="nothingtoshow">
        <h2>您还没有收藏任何内容哦！</h2>
        <h2>点击<a href="javascript:void(0);" onclick="addContent()">添加内容</a></h2>
    </div>
    <%        } else {
            if (request.getAttribute("subtitle") != null) {
    %>
    <h3>${subtitle}</h3>
    <%
            }
            for (ContentVo content :
                    contents) {
//                content.fetchTitlePict();
    %>
    <div class="content col-xs-3" id="content-<%= content.getId() %>">
        <div id="tags" class="content-tags">
            <%
                List<Tag> tags = content.getTags();
                if (tags != null) {
                    for (Tag tag :
                            tags) {
            %>
            <a class="tag-small" id="tag-<%= tag.getId() %>" href="tag.html?id=<%= tag.getId() %>">
                <%= tag.getTagName() %>
            </a>
            <%
                    }
                }
            %>
        </div>
        <a href="<%= content.getUrl() %>" target="_blank">
            <div id="title" class="content-title">
                <%= content.getTitle() %>
                <%--我是标题我是标题我是标题我是标题我是标题我是标题我是标题我是标题我是标题我是标题我是标题我是标题我是标题我是标题--%>
            </div>
            <div id="pict" class="content-pict">
                <img class="pict-img" src="<%= content.getPict() %>" alt="<%= content.getTitle() %>">
                <%--aaaaaa--%>
            </div>
        </a>
        <div id="time" class="content-time">
            <p style="font-size: 10px; color: #adadad"><%= content.getDate() %></p>
        </div>
        <div id="user" class="content-user">
            <%--<p style="font-size: 10px; color: #adadad">收藏者：<%= content.getUserName() %></p>--%>
            <%--<a href="#" class="pull-right visible-sm-inline-block"><img src="img/edit.png"></a>--%>
            <%--<a href="#" class="pull-right visible-sm-inline-block"><img src="img/delete.png"></a>--%>
            <div style="display: inline-block; float: right;">
                <%--<img class="tool-icon" src="img/edit.png" onclick="">--%>
                <img class="tool-icon" src="img/delete.png" onclick="doDelete(<%=content.getId()%>)">
            </div>

        </div>
    </div>
    <%
            }
        }
    %>
</div>

<%@include file="hiddencards.jsp"%>

<script src="js/contentpage.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
