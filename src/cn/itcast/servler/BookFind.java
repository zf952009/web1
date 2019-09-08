package cn.itcast.servler;

import cn.itcast.data.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookFind", urlPatterns = "/BookFind")
public class BookFind extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            //此实例不需要获取outputStream流对象

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/runoob";
            String username = "root";
            String password = "123456";
            String sql = "select id,name,price,bookCount,author from tb_books";
            //连接数据库
            Connection connection = DriverManager.getConnection(url,username,password);
            //获取查询对象
            Statement statement = connection.createStatement();
            //查询数据
            ResultSet resultSet = statement.executeQuery(sql);

            List<Book> list = new ArrayList<Book>();
            while (resultSet.next()){
                Book book = new Book();
                book.setAuthor(resultSet.getString("author"));
                book.setBookCount(resultSet.getInt("bookCount"));
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setPrice(resultSet.getDouble("price"));
                list.add(book);
            }
            request.setAttribute("list",list);
            request.setAttribute("array","邹芳");
            resultSet.close();statement.close();connection.close();
            //请求转发
            request.getRequestDispatcher("book_list.jsp").forward(request,response);
            return;

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