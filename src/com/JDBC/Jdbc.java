package com.JDBC;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *jdbc程序完成简单操作
 * * @version 1.8
 **/

public class Jdbc {
    public static void main(String[] args) throws SQLException {
        //再项目下创建一个文件夹把jar包导入
        //1：注册驱动
        Driver driver = new Driver();

        //2.得到连接(可以是host也可以是ip地址)
        //mysql的连接本质就是socket连接
        String url ="jdbc:mysql://localhost:3306/ppx_db01";
        //讲用户名和密码放入到properties对象中
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","ppx");

        Connection connect = driver.connect(url, properties);

        //3.执行sql;
        String sql ="delete from  users where id = 12";
        //statement-用于执行静态sql语句并返回其生成结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); //如果是dml语句，返回的就是影响行数

        // 4.关闭资源
        System.out.println(rows>0?"success":"false");
        statement.close();
        connect.close();

    }
}
