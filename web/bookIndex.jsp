<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.05.19
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/AddBook" method="post">
    <table align="center" width="450px">
        <tr>
            <td colspan="2" align="center">
                <h2>图书信息添加</h2>
            </td>
        </tr>
        <tr>
            <td>图书名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>数量</td>
            <td><input type="number" size="0" name="bookCount"></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="添加">
            </td>
        </tr>
    </table>


</form>
</body>
</html>
