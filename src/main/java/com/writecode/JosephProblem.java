package com.writecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MinZeng
 * 时间：2018/9/22.
 * 约瑟夫环的问题
 */
public class JosephProblem {

    //初始顺序：0 1 2 3 4  0 1 3 4
    //退出顺序：2 0 4 1
    //4  3
    private static int getFinalExistNumber(int n, int m) {
        int result = -1;
        if (n < 0 || m < 0) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> existOrder = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            list.add(i);
        }
        int index = -1;
        int count = 0;
        int existedCount = 0;
        while (existedCount != (n + 1)) {
            while (count != m) {
                index = (index + 1) % list.size();
                count++;
            }
            existOrder.add(list.get(index));
            list.remove(index);
            existedCount++;
            index--;
            count = 0;
        }
        if (!existOrder.isEmpty()) {
            result = existOrder.get(existOrder.size() - 1);
        }
        System.out.println(existOrder);
        return result;
    }

    public static void main(String[] args) {
        getFinalExistNumber(4, 3);
    }


}
