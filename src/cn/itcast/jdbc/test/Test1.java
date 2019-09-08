package cn.itcast.jdbc.test;

import cn.itcast.jdbc.JDBCUtils_V1;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test1 {
    @Test
    public void select(){
        Connection connection = null;
        PreparedStatement pStatement =null;
        ResultSet resultSet=null;
        try {
            connection = JDBCUtils_V1.getConnection();
            String sql = "select * from tb_web";
            pStatement = connection.prepareStatement(sql);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JDBCUtils_V1.release(connection, pStatement, resultSet);
    }

}
