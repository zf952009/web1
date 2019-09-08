<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.05.19
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="StudentBatch" class="cn.itcast.servler.StudentBatch"></jsp:useBean>
<%
    int row = StudentBatch.saveBatch();
    out.println("批量插入了["+row+"]条数据!");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
