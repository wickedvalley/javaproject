package com.designpattern.singleton;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 * 饱汉式
 */
public class Singleton2 {
    private static Singleton2 instance =null;

    private Singleton2(){
    }

    public static synchronized Singleton2  getInstance(){
        if (instance==null){
            instance = new Singleton2();
        }
        return instance;
    }
}
