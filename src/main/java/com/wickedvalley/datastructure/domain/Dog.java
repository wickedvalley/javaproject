package com.wickedvalley.datastructure.domain;

/**
 * Created by Administrator on 2018/7/25.
 */
public class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("狗正在啃骨头...");
    }

    public void bark() {
        System.out.println("狗正在叫...");
    }
}
