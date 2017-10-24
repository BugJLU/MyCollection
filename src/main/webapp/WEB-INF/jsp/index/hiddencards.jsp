<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2017/10/22
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>

<link href="css/hiddencards.css" rel="stylesheet"/>

<%--<div id="hid" style="z-index: 10000"></div>--%>
<div class="layer-background" id="hidden-background" style="display: none">
    <div class="layer-foreground container" id="addCard" style="width: 500px; height: 400px; border: solid">
        <h3>添加内容</h3>
        <hr color="#A0A0A0"/>
        <form id="addform" class="form-horizontal hidden-form" role="form" action="addcontent.html" method="post">
            <div class="form-group">
                <label class="control-label" for="url">网址</label>
                <input class="form-control" id="url" name="url" type="text">
            </div>
            <div class="form-group">
                <label class="control-label" for="tags">标签（以半角逗号分割）</label>
                <input class="form-control" id="tags" name="tags" type="text">
            </div>
            <div class="form-group">
                <label class="control-label">权限</label>
                <div>
                    <label class="radio-inline">
                        <input type="radio" name="pms" id="pms1" value="0" checked> 所有人可见
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="pms" id="pms0" value="1"> 仅自己可见
                    </label>
                </div>
            </div>
        </form>
        <div class="button-group pull-right">
            <button type="button" class="btn btn-default btn-success btn-block card-btn" onclick="doAdd()">添加</button>
            <button type="button" class="btn btn-default btn-block card-btn" onclick="closeCard()">关闭</button>
        </div>
    </div>
</div>
