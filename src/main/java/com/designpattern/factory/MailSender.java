package com.designpattern.factory;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 */
public class MailSender implements Sender{
    @Override
    public void send() {
        System.out.println("MailSender is sending ...");
    }
}
