package com.designpattern.dynamicproxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    //目标对象
    private Object target;

    public ProxyFactory(Object target){
        this.target = target ;
    }

    //依据目标对象生成代理类的对象
    public Object newProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态代理--开启事物");
                        Object result = method.invoke(target,args);
                        System.out.println("动态代理--提交事物");
                        return result;
                    }
                });
    }

}
