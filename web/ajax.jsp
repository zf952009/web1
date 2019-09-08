<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.07.11
  Time: 23:36
  Name: ajax
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
</head>
<body>
<div style="color: red; float: right ;padding-right: 50px; padding-bottom: 10px">一共--<span id="count"></span>--条数据
</div>
<input type="submit" name="submit" value="ajax请求数据" style="width: 95%;margin-left: 20px"
       class="layui-btn layui-btn-warm">
<a href="JavaScript:;" id="Delall" value="" style="width: 95%;margin-left: 20px; margin-top:10px;"
   class="layui-btn layui-btn-normal">ajax清空数据</a>

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
    $("a[id='Delall']").on("click", function () {
        if (confirm("确认清空")) {
            $("table>tr>td").remove();
        }
    });


    $("input[name='submit']").on("click", function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/ajaxServlet",
            dataType: "json",
            success: function (data) {
                var count = data.length;
                var table = $(".layui-table");
                $("#count").html(count);
                for (var i = 0; i < data.length; i++) {
                    var id = data[i].id;
                    var name = data[i].name;
                    var url = data[i].url;
                    var res = data[i].res;
                    table.append("<tr>" +
                        "<td>" + id + "</td>" +
                        "<td>" + "<a href='" + url + "' target='_blank'>" + name + "</a> </td>" +
                        "<td>" + "<a href='JavaScript:;?id=" + id + "' class='layui-btn layui-btn-danger del'>删除" + "</td>" +
                        "</tr>"
                    );
                }
            },
            error: function () {
                alert("error");
            },
        });
        return false;
    });

</script>
</body>
</html>
