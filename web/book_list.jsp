<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.itcast.data.Book" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.05.19
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书信息</title>
</head>
<body>
<table align="center" width="500" border="1" bgcolor="#f0f8ff">
    <tr>
        <td colspan="6" align="center"><h3>图书信息列表</h3></td>
    </tr>
    <tr align="center">
        <td>ID</td>
        <td>图书名称</td>
        <td>价格</td>
        <td>数量</td>
        <td>作者</td>
        <td>确认修改</td>
    </tr>
    <c:forEach items="${requestScope.list}" var="values" varStatus="id">
        <form action="${pageContext.request.contextPath}/UpdateBook" method="post">
            <tr align="center">
                <td>${values.id}</td>
                <input type="hidden" value="${values.id}" name="id" >
                <td><input type="text" value="${values.name}" name="name"></td>
                <td><input type="text" value="${values.price}" name="price"></td>
                <td><input type="number" value="${values.bookCount}" name="bookCount"></td>
                <td><input type="text" value="${values.author}" name="author"></td>
                <td>
                    <input type="submit" value="修改">
                    <a href="${pageContext.request.contextPath}/UpdateBook?id=${values.id}">删除</a>
                </td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>
