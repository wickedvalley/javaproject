package com.designpattern.dynamicproxy.staticproxy;

public class UserDao implements IUserDao {


    @Override
    public void save() {
        System.out.println("用户保存文件");
    }
}
