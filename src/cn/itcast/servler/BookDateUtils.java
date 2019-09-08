package cn.itcast.servler;

import cn.itcast.data.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookDateUtils {
    private static final String UserName = "root";
    private static final String Password = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/runoob?useUnicode=true&characterEncoding=utf-8";
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, UserName, Password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //更新数据
    public static boolean update_tb_book(Book book) {
        //更新语句
        String sql = "update tb_books set name=?,price=?,bookCount=?,author=? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setDouble(2, book.getPrice());
            preparedStatement.setInt(3, book.getBookCount());
            preparedStatement.setString(4, book.getAuthor());
            preparedStatement.setInt(5, book.getId());
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    //数据删除
    public static boolean delete_tb_book(int id) {
        String sql = "delete from tb_books where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();//执行删除
            connection.close();preparedStatement.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
