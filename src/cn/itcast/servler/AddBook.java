package cn.itcast.servler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "AddBook", urlPatterns = "/AddBook")
public class AddBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/runoob";
            String username = "root";
            String password = "123456";
            //数据添加语句，?表示数据占位符
            String sql = "insert into tb_books(name,price,bookCount,author) values(?,?,?,?)";
            //连接数据库
            Connection connection = DriverManager.getConnection(url,username,password);
            //sql语句装载,获取添加数据对象
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            //数据状态
            preparedStatement.setString(1,request.getParameter("name"));
            preparedStatement.setDouble(2,Double.parseDouble(request.getParameter("price")));
            preparedStatement.setInt(3,Integer.parseInt(request.getParameter("bookCount")));
            preparedStatement.setString(4,request.getParameter("author"));
            //执行数据添加，返回值是受影响的数据
            int row = preparedStatement.executeUpdate();
            if (row>0){
                response.setContentType("text/html;charset=utf-8");
                response.setCharacterEncoding("utf-8");
                request.setCharacterEncoding("utf-8");
               response.getWriter().write("数据添加成功!!");
            }

        }catch (Exception e){
            //数据添加失败，返回主页
            response.sendRedirect("/JavaWeb/bookIndex.jsp");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}