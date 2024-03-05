package utilities;

import com.mysql.cj.jdbc.ClientPreparedStatement;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String driverClass;
    private static String url;
    private static String user;
    private static String password;
    private JDBCUtil(){}; // 私有化构造方法使其不能够new出来

    static { // 给属性赋值
        try {
            InputStream resourceAsStream = JDBCUtil.class.getClassLoader().
                    getResourceAsStream("resources/config.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            // 注册驱动
            Class.forName(driverClass);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() { // 获取连接
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void closeConnection(Statement statement, Connection connection) {
        closeConnection(null, statement, connection);
    }

    public static void main(String[] args) {
        //System.out.println(JDBCUtil.driverClass);
        //try {
        //    Connection connection = JDBCUtil.getConnection();
        //    Statement statement = connection.createStatement();
        //    ResultSet resultSet = statement.executeQuery("SELECT * FROM user_info");
        //    // 迭代处理查询结果
        //    while (resultSet.next()) {
        //        // 通过列名或索引获取每一列的值
        //        // 这里假设第一列的列名为 "column_name"，你需要将其替换为实际的列名
        //        String columnValue = resultSet.getString("user_ID");
        //        // 处理获取到的列值
        //        System.out.println("Column Value: " + columnValue);
        //    }
        //    resultSet.close();
        //    statement.close();
        //    connection.close();
        //
        //}catch (Exception e) {
        //    e.printStackTrace();
        //}
    }
}
