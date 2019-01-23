package com.designpattern.observe;

/**
 * Created by MinZeng
 * 时间：2018/9/13.
 *
 * 观察者模式：
 *
 * MySubject类就是我们的主对象，Observer1和Observer2是依赖于MySubject的对象，当MySubject变化时，Observer1和Observer2必然变化
 */
public interface Observer {
    void update();
}
