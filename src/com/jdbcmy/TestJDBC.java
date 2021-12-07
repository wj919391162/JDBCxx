package com.jdbcmy;

/**
 *实现类
 **/

public class TestJDBC {
    public static void main(String[] args){

        Jdbcinterface jdbcinterface = new OracleJdbclmpl();
        jdbcinterface.getConnection(); //通过接口来调用实现类【动态绑定】
        jdbcinterface.crud();
        jdbcinterface.close();
    }
}
