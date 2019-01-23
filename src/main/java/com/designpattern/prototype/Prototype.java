package com.designpattern.prototype;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class Prototype implements Cloneable {

    public Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

}
