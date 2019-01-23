package com.designpattern.proxy;

import com.designpattern.decorator.Sourceable;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class ProxyTest {

    public static void main(String[] args) {
        Sourceable sourceable = new Proxys();
        sourceable.method();
    }

}
