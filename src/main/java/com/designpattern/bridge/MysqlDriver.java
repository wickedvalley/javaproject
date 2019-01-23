package com.designpattern.bridge;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class MysqlDriver implements Driver{
    @Override
    public void drive() {
        System.out.println("mysql ...");
    }
}
