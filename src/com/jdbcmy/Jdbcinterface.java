package com.jdbcmy;

/**
 *jdbc接口
 **/


public interface Jdbcinterface {

    public Object getConnection();

    public void crud();

    public void close();
}
