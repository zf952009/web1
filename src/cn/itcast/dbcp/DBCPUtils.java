package cn.itcast.dbcp;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBCPUtils {
    private static DataSource dataSource;

    static {
        /*加载配置文件
         * */
        try {
            InputStream inputStream = DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            //加载输入流
            properties.load(inputStream);
            //创建数据源
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
