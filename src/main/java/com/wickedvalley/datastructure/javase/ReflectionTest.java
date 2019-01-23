package com.wickedvalley.datastructure.javase;

import com.wickedvalley.datastructure.domain.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射的一些测试
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {

        Person person = new Person();

        //1.获取class方式一
        Class clazz = person.getClass();

        //2.获取class方式二
        clazz = Person.class;

        //3.获取class方式三
        clazz = Class.forName("com.wickedvalley.datastructure.domain.Person");

        //获取类的全限定名
        System.out.println(clazz.getName());

        //获取所有的字段，包括private的
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getName());
        }

        //获取所有的方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method.getName());
        }


        Class parent = clazz.getSuperclass();
        //获取所有的方法
        Method[] methods2 = parent.getDeclaredMethods();
        for (Method method : methods2){
            System.out.println(method.getName());
        }


    }



}
