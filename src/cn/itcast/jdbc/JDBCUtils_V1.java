package cn.itcast.jdbc;

import java.sql.*;

/*
 * 提供数据连接和释放资源
 *
 * */
public class JDBCUtils_V1 {

    /*
     * 获取连接
     * */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://127.0.0.1:3306/runoob?useUnicode=true&characterEncoding=utf8&useSSL=true";
            String user = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }
        return connection;
    }

    /*
     *释放资源
     * */
    public static void release(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
