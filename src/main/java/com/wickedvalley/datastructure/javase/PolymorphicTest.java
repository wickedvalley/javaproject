package com.wickedvalley.datastructure.javase;

import com.wickedvalley.datastructure.domain.Animal;
import com.wickedvalley.datastructure.domain.Cat;

/**
 * 多态存在的三个必要条件
 * 1.继承（或者是实现）
 * 2.重写
 * 3.父类引用指向子类对象
 */
public class PolymorphicTest {

    public static void main(String[] args) {

        //向上转型，隐藏子类特有的属性和方法
        Animal animal = new Cat();
        animal.eat();

        //向下转型，获取子类的特殊方法
        Cat cat = (Cat) animal;
        cat.work();

    }
}
