package com.jdbcmy;

public class OracleJdbclmpl implements Jdbcinterface{
    @Override
    public Object getConnection() {
        System.out.println("已得到Oracle连接");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("已得到Oracle连接");
    }

    @Override
    public void close() {
        System.out.println("close连接");
    }
}
