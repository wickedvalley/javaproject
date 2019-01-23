package com.designpattern.factory;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class NormalSenderFactory {

    public Sender produce (String type){
        if ("sms".equals(type)){
            return new SmsSender();
        }else if ("mail".equals(type)){
            return new MailSender();
        }else {
            return null;
        }
    }
}
