package com.designpattern.decorator;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("source method...");
    }
}
