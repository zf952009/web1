package cn.itcast.data;

import org.dom4j.io.OutputFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

@WebServlet(name = "TestDate", urlPatterns = "/TestDate")
public class TestDate extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/teching-db";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    public TestDate() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Connection connection = null;
        Statement statement = null;
        OutputStream outputStream = response.getOutputStream();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(DB_URL,USER,PASS);

            statement = connection.createStatement();
            String sql="select * from coursetable";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                String name = resultSet.getString("course_name");
                outputStream.write(name.getBytes());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}