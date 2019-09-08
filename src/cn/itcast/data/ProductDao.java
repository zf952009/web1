package cn.itcast.data;

import org.junit.Test;

import javax.swing.plaf.synth.SynthScrollPaneUI;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
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
    * 商品分页查询所有商品信息
    * @param page页数
    * @return list<product>
    * */
    @Test
    public List<Product> find(int page){
        List<Product> list = new ArrayList<>();
        String sql = "select id,name,price,num,unit from tb_product order by id desc limit ?,?";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,(page-1)*Product.PAGE_SIZE);
            preparedStatement.setInt(2,Product.PAGE_SIZE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setNum(resultSet.getInt("num"));
                product.setPrice(resultSet.getDouble("price"));
                product.setUnit(resultSet.getString("unit"));
                list.add(product);
            }
            resultSet.close();preparedStatement.close();connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    /*
    * 查询总记录数
    * @return 总记录数
    * */
    public int findCount(){
        int count=0;
        try {
            Connection connection = getConnection();//获取数据库连接
            String sql = "select count(*) from tb_product";//查询总记录数sql语句
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                count=resultSet.getInt(1);//记录总记录数
            }
            connection.close();statement.close();resultSet.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;//返回总记录数
    }

}
