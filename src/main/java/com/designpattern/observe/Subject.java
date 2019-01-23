package com.designpattern.observe;

/**
 * Created by MinZeng
 * 时间：2018/9/13.
 * 主题接口
 */
public interface Subject {

    void add(Observer observer);

    void delete(Observer observer);

    void notifyAllObservers();

    void operation();

}
