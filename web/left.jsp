<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.07.09
  Time: 12:25
  Name: left
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>后台管理系统</title>
    <meta name="author" content="DeathGhost"/>

</head>

<body>
<aside class="lt_aside_nav content mCustomScrollbar" style="top:0">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
        <li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">用户管理</a>
            <dl class="layui-nav-child">
                <dd>
                    <a href="${pageContext.request.contextPath}/FileList" target="mainFrame">知识清单</a>
                </dd>
                <dd>
                    <a href="${pageContext.request.contextPath}/ajax.jsp" target="mainFrame">ajax拉取数据</a>
                </dd>
                <dd>
                    <a href="${pageContext.request.contextPath}/ajaxall.jsp" target="mainFrame">ajax异步加载数据</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
            <a href="javascript:;">课程管理</a>
            <dl class="layui-nav-child">
                <dd>
                    <a href="course.html" target="mainFrame">查看课程</a>
                </dd>
                <!--<dd>
                    <a href="{:U('admin/index/managecourse')}" target="mainFrame">管理课程</a>
                </dd>-->
                <dd><a href="updatecourse.html" target="mainFrame">添加课程</a></dd>
            </dl>
        </li>
    </ul>
</aside>

<link rel="stylesheet" type="text/css" href="public/css/layui.css"/>
<script src="public/layui.all.js"></script>
<script>
    (function ($) {
        $(window).load(function () {
            $("a[rel='load-content']").click(function (e) {
                e.preventDefault();
                var url = $(this).attr("href");
                $.get(url, function (data) {
                    $(".content .mCSB_container").append(data);
                    $(".content").mCustomScrollbar("scrollTo", "h2:last");
                });
            });
            $(".content").delegate("a[href='top']", "click", function (e) {
                e.preventDefault();
                $(".content").mCustomScrollbar("scrollTo", $(this).attr("href"));
            });

        });
    });
</script>
</body>

</html>
