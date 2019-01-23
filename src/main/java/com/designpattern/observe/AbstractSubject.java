package com.designpattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MinZeng
 * 时间：2018/9/13.
 */
public abstract class AbstractSubject implements Subject {

    List<Observer> list = new ArrayList<Observer>();

    @Override
    public void add(Observer observer) {
        list.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : list){
            observer.update();
        }
    }

}
