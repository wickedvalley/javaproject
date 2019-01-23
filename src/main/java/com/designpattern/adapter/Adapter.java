package com.designpattern.adapter;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class Adapter extends Source implements Targetable{


    @Override
    public void method2() {
        System.out.println("This is targetable method...");
    }
}
