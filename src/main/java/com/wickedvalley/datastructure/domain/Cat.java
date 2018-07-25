package com.wickedvalley.datastructure.domain;

/**
 * Created by Administrator on 2018/7/25.
 */
public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫正在吃鱼...");
    }


    //猫独有的方式
    public void work() {
        System.out.println("猫在用爪子抓老鼠...");
    }
}
