package com.JDBC;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc02 {

    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        //通过properties对象获取相关配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String psw = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName("com.mysql.jdbc.Driver");  //可以不写
        Connection connection = DriverManager.getConnection(url, user, psw);

        System.out.println("方式5="+connection);
    }
}
