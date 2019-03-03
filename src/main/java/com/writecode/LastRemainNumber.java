package com.writecode;

import java.util.ArrayList;
import java.util.List;

public class LastRemainNumber {

    /**
     * 约瑟夫环问题
     *n=6 ,  m=2
     * 0 1 2 3 4 5
     *   1
     * 0 2 4 5
     *
     * 1 4
     * */

    public static int LastRemaining_Solution(int n, int m) {
        if(n==0){
            return -1;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int index=-1;
        int len =0;
        while (list.size()>1){
            index=(index+1)%list.size();
            len++;
            if(len==m){
                list.remove(index);
                index=(index-1)%list.size();
                len=0;
            }
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(50,3));
    }
}
