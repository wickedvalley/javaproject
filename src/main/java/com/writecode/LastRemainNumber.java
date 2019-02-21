package com.writecode;

import java.util.ArrayList;
import java.util.List;

public class LastRemainNumber {

    /**
     *n=6 ,  m=2
     * 0 1 2 3 4 5
     *   1
     * 0 2 4 5
     *
     * 1 4
     * */
    private static int lastRemainNumber(int n ,int m){
        List<Integer> list  = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int count = 0;
        int index =-1;
        while (list.size()!=1){
            index=(index+1)%list.size();
            count++;
            if (count == m){
                System.out.println(list.get(index));
                list.remove(index);
                index=(index-1)%list.size();
                count=0;
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        lastRemainNumber(6,2);
    }
}
