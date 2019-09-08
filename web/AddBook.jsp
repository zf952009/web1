<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2019.05.19
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="book" class="cn.itcast.data.Book"></jsp:useBean>
<jsp:setProperty name="book" property="*"></jsp:setProperty>
<%
try {
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/runoob";
    String name = "root";
    String password = "123456";
    Connection connection = DriverManager.getConnection(url,name,password);//连接数据库
    String sql = "insert info tb_books(name,price,bookCount,author) values(?,?,?,?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);

    preparedStatement.setString(1,book.getName());
    preparedStatement.setDouble(2,book.getPrice());
    preparedStatement.setInt(3,book.getBookCount());
    preparedStatement.setString(4,book.getAuthor());

    int row = preparedStatement.executeUpdate();//数据添加
    if (row>0){
        out.println("成功添加了"+row+"条数据");
    }
   /* preparedStatement.close();
    connection.close();*/

}catch (Exception e){
    out.println("图书添加失败");
   throw new RuntimeException(e);
}
%>
<html>
<head>
    <title></title>
</head>
<body>
<a href="bookIndex.jsp">返回添加页面</a>
</body>
</html>
