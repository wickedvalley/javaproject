package com.designpattern.bridge;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class DriverManagement extends Bridge {

    public void method(){
        getDriver().drive();
    }
}
