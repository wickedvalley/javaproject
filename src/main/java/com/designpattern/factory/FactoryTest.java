package com.designpattern.factory;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class FactoryTest {


    public static void main(String[] args) {

        //常规工厂测试
        //1.创建工厂
        NormalSenderFactory senderFactory = new NormalSenderFactory();

        //2.工程生产对象
        Sender sender = senderFactory.produce("sms");

        //3.相应的对象调用相应的方法
        sender.send();


        //-------------------------------
        //多个工厂方法模式
        ManySenderFactory manySenderFactory = new ManySenderFactory();
        manySenderFactory.produceMailSender().send();


        //-------------------------------
        //静态工厂
        StaticFactory.produceSmsSender().send();





    }
}
