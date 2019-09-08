<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<table class="layui-table" lay-skin="line row" style="width: 95%;margin-left: 20px">
    <thead>
    <tr>
        <th>编号</th>
        <th>文章名</th>
        <th>操作</th>
    </tr>
    </thead>
    <tr class="list" v-for="v in messages">
        <td>{{v.id}}</td>
        <td>
            <a href="{{v.url}}" target="_blank">{{v.name}}</a>
        </td>
        <td>
            <a href="JavaScript:;{{v.url}}"
               class="layui-btn layui-btn-primary del">删除</a>
        </td>
    </tr>
</table>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/layui.css"/>
<script src="${pageContext.request.contextPath}/public/layui.all.js"></script>
<script src="${pageContext.request.contextPath}/public/jquery-3.4.1.js"></script>
<script src="https://cdn.staticfile.org/vue/2.2.2/vue.min.js"></script>

<script>
    $(document).ready(function () {
        var doment = $(this);
        var method = $(this).val();
        if (method == "搜索") {
            var name = $("input[name='name']").val();
            var id = $("input[name='id']").val();
            var findata = {"name": name, "id": id};
        }
        //清空全部数据
        $("table tr td").remove();
        $.ajax({
            url: "${pageContext.request.contextPath}/FileListFind",
            dataType: "json",
            type: "post",
            data: findata,
            success: function (data) {
                var messages = new Vue({
                    el:'.list',
                    data:{
                        messages:data,
                    },
                });
                console.log(data)
            },
            error: function () {
                alert("error")
            },
        });
    });

</script>


</body>
</html>