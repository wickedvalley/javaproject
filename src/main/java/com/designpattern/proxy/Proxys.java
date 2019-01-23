package com.designpattern.proxy;

import com.designpattern.decorator.Source;
import com.designpattern.decorator.Sourceable;

import java.lang.reflect.Proxy;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class Proxys implements Sourceable{

    private Source source;

    public Proxys(){
        this.source = new Source();
    }

    @Override
    public void method() {
        System.out.println("before proxy...");
        source.method();
        System.out.println("after proxy...");
    }

}
