package com.designpattern.adapter;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class AdapterTest {

    public static void main(String[] args) {
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }

}
