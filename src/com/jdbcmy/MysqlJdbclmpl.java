package com.jdbcmy;

/**
 *模拟数据库实现jdbc接口
 **/

public class MysqlJdbclmpl implements Jdbcinterface{
    @Override
    public Object getConnection() {
        System.out.println("已得到连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("已得到zsgc");
    }

    @Override
    public void close() {

    }
}
