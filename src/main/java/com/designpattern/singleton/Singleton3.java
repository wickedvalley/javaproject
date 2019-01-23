package com.designpattern.singleton;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 * 第三种方式
 *依然是饱汉的改进方式
 */
public class Singleton3 {
    private static Singleton3 instance=null;

    private Singleton3(){
    }

    public static Singleton3 getInstance (){
        if (instance==null){
           synchronized (Singleton3.class){
                if (instance == null){
                    instance = new Singleton3();
                }
          }
        }
        return instance;
    }

}
