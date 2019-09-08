package cn.itcast.servler;

import org.junit.Test;

import java.beans.Transient;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class StudentBatch {
    /*
    * 获取数据库连接
    * @return Connection对象
    * */
    private Connection getConnection(){
        String UserName = "root";
        String password = "123456";
        String url = "jdbc:mysql://localhost:3306/runoob?useUnicode=true&characterEncoding=utf-8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection  connection= DriverManager.getConnection(url,UserName,password);
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
    /*
    * 批量添加数据
    * @retuen 受影响的数据行数
    * */
    @Test
    public int saveBatch(){
        int row=0;
        try {
            String sql = "insert into tb_student(name,sex,age) values (?,?,?)";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            //随机数生成，生成年龄
            Random random = new Random();
            for (int i=0;i<10;i++){
                preparedStatement.setString(1,"学生"+i);
                preparedStatement.setBoolean(2,i%2==0?true:false);
                preparedStatement.setInt(3,random.nextInt(5)+10);
                preparedStatement.addBatch();//批处理命令
            }
            int[] rows = preparedStatement.executeBatch();
            row = rows.length;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return row;
    }
}
