package com.wickedvalley.datastructure.datastructureimpl.datastructure8_sorter;

import java.util.*;

/**
 * Created by MinZeng
 * 时间：2018/9/24.
 */
public class MySorter {

    /**
     * 冒泡排序
     */
    //2 1 3 4 5 6 8 7 10 9
    private void bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    //2 1 3 4 5 6 8 7 10 9
    private void selectSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    /**
     * 直接插入排序
     */
    //1 3 4   2 5 6 8 7 10 9
    private void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int target = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > target) {
                array[j + 1] = array[j];
                j--;
            }
            array[++j] = target;
        }
    }

    /**
     * 希尔排序
     */
    private void shellSort(int[] array) {
        int len = array.length;
        //首先分组
        for (int gap = len / 2; gap > 0; gap /= 2) {
            //对每个分组执行插入排序
            for (int i = gap; i < len; i++) {
                int target = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] > target) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[++j] = target;
            }
        }
    }

    /**
     * 快速排序
     */
    //1 3 4   2 5 6 8 7 10 9
    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int target = array[left];
            while (i < j) {

                //右侧找到第一个比target 小的数放在左边
                while (i < j && array[j] > target) {
                    j--;
                }
                if (i < j) {
                    array[i] = array[j];
                    i++;
                }

                //左侧找到第一个比target大的数放在右边
                while (i < j && array[i] < target) {
                    i++;
                }
                if (i < j) {
                    array[j] = array[i];
                    j--;
                }
            }
            array[i] = target;
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        }

    }

    /**
     * 两个有序数组，数组中存在重复数字，合并成一个有序数组，去除重复数字
     */
    private Integer[] combineTwoArray(int[] a, int[] b) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i: a){
            list.add(i);
        }
        for(int i:b){
            list.add(i);
        }
        Collections.sort(list);
        Set<Integer> set = new HashSet<Integer>(list);
        Integer [] array =new Integer[set.size()];
        set.toArray(array);
        return array;
    }




    /**
     * 二分查找
     */
    private int binarySearch(int[] array, int target) {
        int result = -1;
        int low = 0;
        int high = array.length;
        int middle = (low + high) / 2;
        while (low < high) {
            if (array[middle] < target) {
                low = middle + 1;
            } else if (array[middle] > target) {
                high = middle - 1;
            } else {
                return middle;
            }
            middle = (low + high) / 2;
        }
        return result;
    }


    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        int[] array = {2, 1, 3, 5, 4, 7, 6, 8, 10, 9, 6};

        MySorter mySorter = new MySorter();

        //冒泡排序
//        mySorter.bubbleSort(array);
//        printArray(array);

        //选择排序
//        mySorter.selectSort(array);
//        printArray(array);

        //插入排序
//        mySorter.insertSort(array);
//        printArray(array);

        //快速排序
//        mySorter.quickSort(array, 0, array.length - 1);
//        printArray(array);

        //希尔排序
//        mySorter.shellSort(array);
//        printArray(array);

        //二分查找
//        int index = mySorter.binarySearch(array, 7);
//        System.out.println(index);


    }


}
