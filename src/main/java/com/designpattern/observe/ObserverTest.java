package com.designpattern.observe;

/**
 * Created by MinZeng
 * 时间：2018/9/13.
 */
public class ObserverTest {


    public static void main(String[] args) {
        Subject subject = new MySubject();
        subject.add(new Observer1());
        subject.add(new Observer2());
        subject.operation();

    }

}
