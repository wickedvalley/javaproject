package com.wickedvalley.datastructure.test;

/**
 * Created by MinZeng
 * 时间：2018/9/11.
 */
public class Base
{
    private String baseName = "base";
    public Base()
    {
        System.out.println("父类构造函数初始化");
        callName();
    }

    public void callName()
    {
        System. out. println(baseName);
    }

    static class Sub extends Base
    {
        private String baseName = "sub";
        {
            System.out.println(baseName);
        }

        public Sub (){
            System.out.println("子类构造函数初始化");
        }
        public void callName()
        {
            System. out. println ("----"+baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base b = new Sub();
    }
}