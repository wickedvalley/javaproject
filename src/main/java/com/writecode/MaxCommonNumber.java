package com.writecode;

/**
 * Created by MinZeng
 * 时间：2018/9/22.
 */
public class MaxCommonNumber {

    //求m和n的最大公约数
    private static int maxCommonNumber(int m, int n) {
        int result = -1;
        int max = Math.max(m, n);
        int min = Math.min(m, n);
        int modValue;
        while (max%min!=0){
            modValue = max%min;
            max = min;
            min=modValue;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(maxCommonNumber(15,9));
    }
}
