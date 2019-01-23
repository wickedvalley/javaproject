package com.designpattern.builder;

import com.designpattern.factory.MailSender;
import com.designpattern.factory.Sender;
import com.designpattern.factory.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MinZeng
 * 时间：2018/9/12.
 * 建造者模式
 */
public class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public void buildSms(int count){
        for(int i=0;i<count;i++){
            list.add(new SmsSender());
        }
    }

    public void buildMails(int count){
        for(int i=0;i<count;i++){
            list.add(new MailSender());
        }
    }

    public List<Sender> getList(){
        return list;
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.buildMails(5);
        builder.buildSms(5);

        List<Sender> senderList = builder.getList();
        for (Sender sender : senderList){
            sender.send();
        }

    }
}
