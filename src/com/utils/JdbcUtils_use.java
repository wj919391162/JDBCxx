package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *jdbc工具类测试类
 * * @version 1.8
 **/

public class JdbcUtils_use {

    public static void main(String[] args) {
        JdbcUtils_use jdbcUtils_use = new JdbcUtils_use();
        jdbcUtils_use.testDML();
    }

    public void testDML(){

        //得到连接
        Connection connection = null;

        //sql语句
        String sql ="update users set name = ? where id = ?";

        PreparedStatement preparedStatement = null;

        //创建PreparedStatement对象
        try {
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //给占位符赋值
            preparedStatement.setString(1,"wochao");
            preparedStatement.setString(2,"4");
            //执行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null,preparedStatement,connection);
        }

    }
}
