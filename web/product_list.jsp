<%@ page import="java.util.List" %>
<%@ page import="cn.itcast.data.Product" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.05.20
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品信息显示页面</title>
</head>
<body>
<table align="center" width="450" border="1">
    <tr>
        <td colspan="5" align="center">
            <h2>所有商品信息</h2>
        </td>
    </tr>
    <tr align="center">
        <td>ID</td>
        <td>商品名称</td>
        <td>价格</td>
        <td>数量</td>
        <td>单位</td>
    </tr>
    <%
        List<Product> list = (List<Product>) request.getAttribute("list");
        for (Product product : list) {
    %>
    <tr align="center">
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getPrice()%></td>
        <td><%=product.getNum()%></td>
        <td><%=product.getUnit()%></td>
    </tr>
    <%
        }
    %>
    <tr align="center">
        <td colspan="5">
            <%=request.getAttribute("bar")%>
        </td>
    </tr>

</table>
</body>
</html>
