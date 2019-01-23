package com.designpattern.factory;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class StaticFactory {


    public static Sender produceSmsSender(){
        return new SmsSender();
    }

    public static Sender produceMailSender(){
        return new MailSender();
    }





}
