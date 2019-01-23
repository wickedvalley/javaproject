package com.designpattern.observe;

/**
 * Created by MinZeng
 * 时间：2018/9/13.
 */
public class MySubject extends AbstractSubject implements Subject{


    @Override
    public void operation() {
        System.out.println("update self...");
        notifyAllObservers();
    }
}
