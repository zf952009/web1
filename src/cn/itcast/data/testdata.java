package cn.itcast.data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;



@WebServlet(name = "testdata", urlPatterns = "/testdata")
public class testdata extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        try {
            //注册jdbc驱动
            String conn = Class.forName("com.mysql.jdbc.Driver").toString();
            //连接数据库信息
            String name = "root";
            String password = "123456";
            String url = "jdbc:mysql://localhost:3306/teching-db?characterEncoding=utf-8";
            String sql = "select * from coursetable";
            //连接数据库
            Connection connection = DriverManager.getConnection(url,name,password);
            //查询
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            //添加
            PreparedStatement preparedStatement = connection.prepareStatement("insert into coursetable() values (?,?,?,?,?)");
            while (resultSet.next()){
                System.out.println(resultSet.getString("image_path"));
                //获取流对象
                resultSet.getBinaryStream("course_name");

                //
                writer.write(resultSet.getString("course_name")+"</br>");
            }
            writer.flush();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}