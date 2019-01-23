package com.designpattern.decorator;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class Decorator implements Sourceable {
    Sourceable sourceable;

    public Decorator(Source source){
        this.sourceable = source;
    }

    @Override
    public void method() {
        System.out.println("before decorator ...");
        sourceable.method();
        System.out.println("after decorator...");
    }
}
