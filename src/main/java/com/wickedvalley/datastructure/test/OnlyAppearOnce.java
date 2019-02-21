package com.wickedvalley.datastructure.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OnlyAppearOnce {

    //题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
    private static List<Integer> onlyAppearOnce(int [] array){
        if (array.length==0){
            return null;
        }
        //返回的结果
        List<Integer> result = new ArrayList<Integer>();
        //去重集合
        Set<Integer> set = new HashSet<Integer>();
        for(int i: array){
            set.add(i);
        }

        for(int i: set){
            int count =0;
            for(int j:array){
                if (j==i){
                    count++;
                }
            }

            if (count==2){
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(onlyAppearOnce(new int[]{2,2,1,3,3,5,6,7,8}));

    }




}
