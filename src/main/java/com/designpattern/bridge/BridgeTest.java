package com.designpattern.bridge;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class BridgeTest {

    public static void main(String[] args) {
        DriverManagement driver = new DriverManagement();
        driver.setDriver(new OracleDriver());
        driver.driver();
    }
}
