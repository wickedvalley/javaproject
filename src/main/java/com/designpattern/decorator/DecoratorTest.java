package com.designpattern.decorator;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class DecoratorTest {


    public static void main(String[] args) {
        Source sourceable = new Source();

        Sourceable decorator = new Decorator(sourceable);

        decorator.method();


    }


}
