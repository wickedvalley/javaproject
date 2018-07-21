package com.wickedvalley.datastructure.datastructureimpl.datastructure8_sorter;

/**
 * 排序
 */
public class Sorter {

    /**
     * 冒泡排序
     * 平均时长：O(n²)
     * 最长时间：O(n²)
     * 稳定性：稳定
     * <p>
     * 原理简介：每一趟两两交换，最大的那个“冒出去”
     * 1.将第一个记录的关键字与第二个记录的关键字进行比较，若为逆序r[1].key>r[2].key，则交换；然后比较第二个记录与第三个记录；依次类推，直至第n-1个记录和第n个记录比较为止——第一趟冒泡排序，结果关键字最大的记录被安置在最后一个记录上
     * <p>
     * 2.对前n-1个记录进行第二趟冒泡排序，结果使关键字次大的记录被安置在第n-1个记录位置
     * <p>
     * 3.重复上述过程，直到“在一趟排序过程中没有进行过交换记录的操作”为止
     */
    public void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
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
     * 平均时长：O(n²)
     * 最长时间：O(n²)
     * 稳定性：不稳定
     * <p>
     * 原理简介：
     * l 首先通过n-1次关键字比较，从n个记录中找出关键字最小的记录，将它与第一个记录交换
     * <p>
     * 2 再通过n-2次比较，从剩余的n-1个记录中找出关键字次小的记录，将它与第二个记录交换
     * <p>
     * 3 重复上述操作，共进行n-1趟排序后，排序结束
     */
    public void selectSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     * 平均时长：O(n²)
     * 最长时间：O(n²)
     * 稳定性：稳定
     * <p>
     * 原理简介：
     * 1 整个排序过程为n-1趟插入，即先将序列中第1个记录看成是一个有序子序列
     * <p>
     * 2 然后从第2个记录开始，逐个进行插入，直至整个序列有序
     */
    public void insertsSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int target = array[i];
            int j = i - 1;
            while (j >= 0 && target < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[++j] = target;
        }
    }

    /**
     * 希尔排序
     * 平均时长：O(n1.3)
     * 最长时间：
     * 稳定性：不稳定
     * <p>
     * 原理简介：
     * 1.先取一个正整数d1<n，把所有相隔d1的记录放一组，组内进行直接插入排序；
     * 2.然后取d2<d1，重复上述分组和排序操作；直至di=1，即所有记录放进一个组中排序为止
     */
    public void shellSort(int[] array) {
        int len = array.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {//分组
            for (int i = gap; i < len; i++) {//从第gap个元素，逐个对其所在组进行直接插入排序操作
                int j = i;
                int target = array[j];
                if (array[j] < array[j - gap]) {//比前一个元素小，则执行组内插入排序
                    while (j - gap >= 0 && target < array[j - gap]) {//执行组内插入排序
                        array[j] = array[j - gap];//移动元素位置
                        j -= gap;
                    }
                    array[j] = target;
                }
            }
        }
    }

    /**
     * 打印数据
     */
    public void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        int[] array = {2, 1, 3, 5, 4, 7, 6, 8, 10, 9};
        Sorter sorter = new Sorter();

        //冒泡排序
        sorter.bubbleSort(array);
        sorter.printArray(array);

        //选择排序
        sorter.selectSort(array);
        sorter.printArray(array);

        //直接插入排序
        sorter.insertsSort(array);
        sorter.printArray(array);

        //希尔排序
        sorter.shellSort(array);
        sorter.printArray(array);


    }
}
