package com.designpattern.builderpattern;

/**
 * Created by MinZeng
 * 时间：2018/9/13.
 * 构造者模式
 */
public class ParamsBuilderTest {

    public static void main(String[] args) {

        ParamsBuilder paramsBuilder = new ParamsBuilder.Builder()
                .username("张三").password("123456").url("http://192.168.0.1").build();
        System.out.println(paramsBuilder.toString());

    }
}
