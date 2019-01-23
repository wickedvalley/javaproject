package com.designpattern.observe;

/**
 * Created by MinZeng
 * 时间：2018/9/13.
 */
public class Observer2 implements Observer{
    @Override
    public void update() {
        System.out.println("observer1 has received...");
    }
}
