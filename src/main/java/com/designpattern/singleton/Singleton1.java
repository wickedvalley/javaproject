package com.designpattern.singleton;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 * 单例模式1：适合于单线程模式下
 */
public class Singleton1 {

    private static Singleton1 instance =null;

    private Singleton1(){

    }

    public Singleton1 getInstance(){
        if (instance==null){
            instance = new Singleton1();
        }
        return instance;
    }

}
