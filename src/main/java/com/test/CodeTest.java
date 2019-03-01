package com.test;

public class CodeTest {

    /**
     *阶乘
     * @param number 输入数据
     * */
    private static int factorial(int number){
        if (number<0){
            throw new IllegalArgumentException("非法参数："+number);
        }
        if(number ==0 || number == 1){
            return number;
        }
        return number*factorial(number-1);
    }

    public static void main(String[] args) {

        System.out.println(factorial(-1));

    }
}
