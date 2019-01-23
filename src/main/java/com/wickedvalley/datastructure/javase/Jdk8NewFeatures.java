package com.wickedvalley.datastructure.javase;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018/7/23.
 * jdk8新特性
 */
public class Jdk8NewFeatures {

    private static List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    /**
     * 1.测试lambda表达式
     */
    public static void test1() {
        list.forEach(e -> System.out.println(e));
    }

    /**
     * 2.Stream函数式操作流元素集合
     */
    public static void test2() {
        List<Integer> nums = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        System.out.println("集合求和："+nums.stream()
                .filter(num->num!=null).distinct().mapToInt(num->num).sum());

        List<Integer> notRepeatNums = nums.stream().filter(num->num!=null).distinct().collect(Collectors.toList());
        System.out.println("不重复且不为null元素："+notRepeatNums);
    }

    public static void main(String[] args) {
        test2();
    }

}
