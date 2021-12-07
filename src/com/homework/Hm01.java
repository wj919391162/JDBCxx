package com.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Hm01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user=properties.getProperty("user");
        String psw=properties.getProperty("password");
        String url=properties.getProperty("url");
        String driver=properties.getProperty("driver");

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, psw);

        String sql = "update users set password='ppx000' where id=4";
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);

        System.out.println(rows>0?"success":"false");
        statement.close();
        connection.close();
    }
}
