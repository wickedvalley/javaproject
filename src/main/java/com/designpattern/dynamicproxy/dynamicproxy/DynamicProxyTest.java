package com.designpattern.dynamicproxy.dynamicproxy;

import com.designpattern.dynamicproxy.staticproxy.IUserDao;
import com.designpattern.dynamicproxy.staticproxy.UserDao;

public class DynamicProxyTest {

    public static void main(String[] args) {
        //目标对象
        IUserDao iUserDao =  new UserDao();

        //依据目标对象生成代理对象
        IUserDao proxyInstance = (IUserDao) new ProxyFactory(iUserDao).newProxyInstance();

        //执行方法
        proxyInstance.save();
    }


}
