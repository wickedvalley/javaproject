package com.designpattern.factory;

import javax.script.ScriptEngine;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class ManySenderFactory {


    public Sender produceSmsSender(){
        return new SmsSender();
    }

    public Sender produceMailSender(){
        return new MailSender();
    }

}
