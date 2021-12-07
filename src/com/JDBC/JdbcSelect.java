package com.JDBC;

import com.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *jdbc工具查找
 * * @version 1.8
 **/

public class JdbcSelect {
    public static void main(String[] args) {

        Connection connection = null;
        String sql = "select * from users where id = ?";
        ResultSet set = null;
        PreparedStatement preparedstatement = null;

        try {
            connection = JdbcUtils.getConnection();
            preparedstatement = connection.prepareStatement(sql);

            preparedstatement.setString(1,"4");
            set = preparedstatement.executeQuery();

            while(set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String psw = set.getString("password");
                String birthday =set.getString("birthday");
                System.out.println(id+"\t"+name+"\t"+psw+"\t"+birthday);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null,preparedstatement,connection);
        }

    }
}
