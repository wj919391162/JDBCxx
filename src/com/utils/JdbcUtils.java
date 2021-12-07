package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 *jdbc工具类完成连接和关闭资源操作
 * * @version 1.8
 **/

public class JdbcUtils {
    //定义相关属性 因为只需要一份所以做成static
    private  static String user;
    private  static String password;
    private  static String url;
    private  static String driver;

    //再static代码块去初始化
    static {

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            //读取相关的属性
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            url=properties.getProperty("url");
            driver=properties.getProperty("driver");
        } catch (IOException e) {
            //在实际开发中可以这样处理
            //将这个编译异常转换成运行异常
            //调用者可以选择 捕获 或者默认处理
            throw new RuntimeException(e);
        }
    }


    //连接数据库，返回Connection
    public static Connection getConnection(){

        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭资源方法
    public static void close(ResultSet set, Statement statement, Connection connection){
        //判定是否为null
        try {
            if (set != null){
                set.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
