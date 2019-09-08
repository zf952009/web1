<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.07.12
  Time: 12:59
  Name: ajaxall
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<div style="color: red; float: right ;padding-right: 50px; padding-bottom: 10px">一共--<span id="count"></span>--条数据
</div>
<table class="layui-table" lay-skin="line row" style="width: 95%;margin-left: 20px">
    <thead>
    <tr>
        <th>编号</th>
        <th>文章名</th>
        <th>操作</th>
    </tr>
    </thead>
</table>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/layui.css"/>
<script src="${pageContext.request.contextPath}/public/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/public/jquery-3.4.1.js"></script>
<script>
    $(function () {
        var table = $("table");
        $.ajax({
            url: "${pageContext.request.contextPath}/AjaxAll",
            dataType: "json",
            success: function (data) {
                $("#count").html(data.length);
                for (var i = 0; i < data.length; i++) {
                    $("table").append("<tr>" +
                        "<td>" + data[i].id + "</td>" +
                        "<td>" + "<a href='" + data[i].url + "' target='_blank'>" + data[i].name + "</a> </td>" +
                        "<td>" + "<a href='JavaScript:;?id=" + data[i].id + "' class='layui-btn layui-btn-primary del'>删除" + "</td>" +
                        "</tr>");
                }
            },
            error: function () {
                console.log("error");
            }
        });
    });

</script>


</body>
</html>
