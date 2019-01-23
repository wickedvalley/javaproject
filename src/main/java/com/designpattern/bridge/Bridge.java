package com.designpattern.bridge;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public abstract class Bridge {
    private Driver driver;

    public void setDriver(Driver driver){
        this.driver = driver;
    }

    public Driver getDriver(){
        return this.driver;
    }

    public void driver(){
        driver.drive();
    }

}
