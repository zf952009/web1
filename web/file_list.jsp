<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.07.09
  Time: 12:21
  Name: file_list
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>title</title>
</head>
<body>


<form action="${pageContext.request.contextPath}/FileListFind" class="layui-form" method="post">
    <h2>this file list</h2>
    <div class="layui-inline">
        <label class="layui-form-label">编号</label>
        <div class="layui-input-inline">
            <input type="text" name="id" autocomplete="off" placeholder="查找ID..." class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">文章名</label>
        <div class="layui-input-inline">
            <input type="text" name="name" autocomplete="off" placeholder="查找文章名..." class="layui-input">
        </div>
    </div>
    <input type="submit" class="layui-btn layui-btn-warm" value="搜索">
</form>
<br/>
<form action="${pageContext.request.contextPath}/FlieListAdd" class="layui-form" method="post">
    <div class="layui-inline">
        <label class="layui-form-label">文章名</label>
        <div class="layui-input-inline">
            <input type="text" name="name" autocomplete="off" placeholder="文章名..." class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <label class="layui-form-label">URL</label>
        <div class="layui-input-inline">
            <input type="tel" name="url" autocomplete="off" class="layui-input" placeholder="URL...">
        </div>
    </div>
    <input type="hidden" name="addId" value="${id}">
    <input type="submit" class="layui-btn" value="添加">
</form>
<div style="color: red; float: right ;padding-right: 50px; padding-bottom: 10px">一共--<span id="count">${count}</span>--条数据
</div>
<table class="layui-table" lay-skin="line row" style="width: 95%;margin-left: 20px">
    <thead>
    <tr>
        <th>编号</th>
        <th>文章名</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${data}" var="val">
        <tr>
            <td>${val.id}</td>
            <td>
                <a href="${val.url}" target="_blank">${val.name}</a>
            </td>
            <td>
                <a href="JavaScript:;?id=${val.id}"
                   class="layui-btn layui-btn-primary del">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/layui.css"/>
<script src="${pageContext.request.contextPath}/public/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/public/jquery-3.4.1.js"></script>
<script>
    //异步删除
    $(".del").on("click", function () {
        var okdel = confirm("确认删除!!!");
        if (okdel) {
            var doment = $(this);
            var data = this.href.split("?")[1];
            var id = data.split("=")[1];
            var ajaxdata = {"id": id};
            $.ajax({
                url: "${pageContext.request.contextPath}/FileListDelete",
                type: "POST",
                data: ajaxdata,
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    var mes = data.mes;
                    if (mes == "ok") {
                        alert("删除成功");
                        doment.parent().parent().remove();
                    } else {
                        alert("删除失败");
                    }
                },
                error: function () {
                    alert("servlet error");
                }
            });
        }
        return false;
    });
    //异步搜索和添加
    $("input:submit").on("click", function () {
        var doment = $(this);
        var method = $(this).val();
        if (method == "搜索") {
            var name = $("input[name='name']").val();
            var id = $("input[name='id']").val();
            var findata = {"name": name, "id": id};

            //清空全部数据
            $("table tr td").remove();
            $.ajax({
                url: "${pageContext.request.contextPath}/FileListFind",
                dataType: "json",
                type: "post",
                data: findata,
                success: function (data) {
                    $("#count").html(data.length);
                    for (var i = 0; i < data.length; i++) {
                        $("table").append("<tr>" +
                            "<td>" + data[i].id + "</td>" +
                            "<td>" + "<a href='" + data[i].url + "' target='_blank'>" + data[i].name + "</a> </td>" +
                            "<td>" + "<a href='JavaScript:;?id=" + data[i].id + "' class='layui-btn layui-btn-primary del'>删除" + "</td>" +
                            "</tr>");
                    }
                    // console.log(data);
                },
                error: function () {
                    alert("error")
                },
            });
        }
        if (method == "添加") {

        }
        return false;
    });
</script>
</body>
</html>
