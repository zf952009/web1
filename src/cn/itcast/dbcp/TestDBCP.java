package cn.itcast.dbcp;

import cn.itcast.jdbc.JDBCUtils_V1;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestDBCP {
    /*
    * 有问题
    * */
    @Test
    public void SelectTest(){
        Connection connection = null;
        PreparedStatement pStatement =null;
        ResultSet resultSet=null;
        try {
            connection = DBCPUtils.getConnection();
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
