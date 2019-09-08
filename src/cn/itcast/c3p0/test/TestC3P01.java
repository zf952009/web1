package cn.itcast.c3p0.test;

import cn.itcast.c3p0.C3P0Utlis1;
import cn.itcast.jdbc.JDBCUtils_V3;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestC3P01 {

    @Test
    public void AddTest(){
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet=null;
        try {
            //使用c3p0获取连接
            connection = C3P0Utlis1.getConnection();
            String sql = "select * from tb_web";
            pStatement = connection.prepareStatement(sql);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JDBCUtils_V3.release(connection, pStatement, resultSet);

    }


    @Test
    public void SelectTest() {
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        //连接池对象，空参数使用默认的连接
//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //使用指定的配置连接数据库
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("test");

        try {
            connection = comboPooledDataSource.getConnection();
            String sql = "select * from tb_web";
            pStatement = connection.prepareStatement(sql);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JDBCUtils_V3.release(connection, pStatement, resultSet);
    }
}
