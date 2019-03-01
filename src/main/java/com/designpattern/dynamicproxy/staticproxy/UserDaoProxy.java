package com.designpattern.dynamicproxy.staticproxy;

/**
 * 代理类
 * */
public class UserDaoProxy implements IUserDao {

    private IUserDao target;

    public UserDaoProxy(IUserDao target){
        this.target=target;
    }

    @Override
    public void save() {
        System.out.println("开启事物");
        target.save();
        System.out.println("提交事物");
    }
}
