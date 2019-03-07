package com.test;

import java.util.Stack;

/**
 * Created by MinZeng
 * 时间：2019/3/4.
 * 进制转换
 */
public class RadixConvert {

    public static String toFourRadix(int number){
        char [] chars = {'0','1','2','3'};
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        while (number>0){
            stack.push(chars[number%4]);
            number/=4;
        }
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    /**
     * 整数n转为任意进制base
     * @param n
     * @param base
     * @return
     * */
    public static String parse(int n,int base){
        StringBuilder sb = new StringBuilder();
        Stack stack=new Stack();
        char digit[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n>0){
            stack.push(digit[n%base]);
            n/=base;
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toFourRadix(1567));

        System.out.println(parse(1567,4));
    }
}
