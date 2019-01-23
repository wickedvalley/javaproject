package com.designpattern.singleton;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 * 饿汉式
 */
public class Singleton4 {

    private static Singleton4 instance = new Singleton4();

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return instance;
    }

}
