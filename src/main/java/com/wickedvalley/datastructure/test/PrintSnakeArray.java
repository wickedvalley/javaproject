package com.wickedvalley.datastructure.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintSnakeArray {

    /**
     *      打印蛇形数组
     *     //    1	   2	6	7	14
     *     //    3     5	8	13	15
     *     //    4	   9	12	16	19
     *     //    10   11	17	18	20
     * @param array 输入的数组
     * */
    private static void printSnakeArray(int [][] array){
        if(array.length == 0){
            throw new RuntimeException("数据为空");
        }
        List<Integer> sortedList = new ArrayList<Integer>();
        int len =array[0].length;

        int xIndex,yIndex;

        //1、从列开始
        for(int y=0;y<len;y++){
            //偶数是反,奇数是正
            List<Integer> temp = new ArrayList<Integer>();

            //横、纵坐标获取
            xIndex=0;
            yIndex=y;

            while (xIndex<array.length&&yIndex>=0){
                temp.add(array[xIndex][yIndex]);
                //斜线遍历
                xIndex++;
                yIndex--;
            }

            //偶数需要反转
            if (y%2==0){
                Collections.reverse(temp);
            }
            sortedList.addAll(temp);
        }

        //2、从行开始遍历
        for(int x=1;x<len;x++){
            //偶数是反,奇数是正
            List<Integer> temp = new ArrayList<Integer>();

            //横、纵坐标获取
            xIndex=x;
            yIndex=len-1;

            while (xIndex<array.length&&yIndex>=0){
                temp.add(array[xIndex][yIndex]);
                //斜线遍历
                xIndex++;
                yIndex--;
            }

            //偶数需要反转
            if (x%2==0){
                Collections.reverse(temp);
            }
            sortedList.addAll(temp);
        }

        System.out.println(sortedList);
    }


    private static void printArray(int [][] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int [][] array={
                 {1,2,6,7,14}
                ,{3,5,8,13,15}
                ,{4,9,12,16,19}
                ,{10,11,17,18,20}
        };

        printSnakeArray(array);
    }

}
