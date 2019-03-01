package com.designpattern.dynamicproxy.staticproxy;

public class UserDaoProxyTest {


    public static void main(String[] args) {

        //1、创建目标对象
        UserDao userDao = new UserDao();

        //2、建立代理对象和目标对象的关系
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);

        userDaoProxy.save();

    }
}
