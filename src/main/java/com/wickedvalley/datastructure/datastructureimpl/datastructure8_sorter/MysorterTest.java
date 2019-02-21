package com.wickedvalley.datastructure.datastructureimpl.datastructure8_sorter;

public class MysorterTest {

    /**
     * 冒泡排序
     */
    //2 1 3 4 5 6 8 7 10 9
    private static void bubbleSort(int [] array){

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1-i;j++){
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }

            }
        }
    }

    /**
     * 选择排序
     */
    //2 1 3 4 5 6 8 7 10 9
    private static void selectSort(int [] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    int temp =array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * 1 5 3 4 2
     * */
    private static void insertSort(int [] array){

        for(int i=1;i<array.length;i++){
            int target = array[i];
            int j =  i -1;
            while (j>=0&&target<array[j]){
                array[j+1]=array[j];
                j--;
            }
            array[++j]=target;
        }
    }

    /**
     * 快速排序
     *
     * 1 5 3 4 2
     * */
    private static void quickSort(int [] array ,int left,int right){
        if (left<right){
            int i=left;
            int j=right;
            int target = array[i];
            while (i<j){

                //右边找到第一个比target小的放左边
                while (i<j&&array[j]>target){
                    j--;
                }
                if (j>i){
                    array[i]=array[j];
                    i++;
                }

                //左边找到第一个比target大的数放右边
                while (i<j&&array[i]<target){
                    i++;
                }
                if (i<j){
                    array[j]=array[i];
                    j--;
                }
            }

            array[i]=target;
            quickSort(array,left,i-1);
            quickSort(array,i+1,right);
        }

    }

    /**
     * 希尔排序
     * 2 1 3 5 6 7
     * */
    private static void shellSort(int [] array){

        for(int gap =array.length/2;gap>0;gap = gap/2){
            //每隔gap个数据进行插入排序
            for(int i = gap ;i<array.length;i=i+gap){
                int target =array[i];
                int j = i-gap;
                while (j>=0&&target<array[j]){
                    array[j+gap]=array[j];
                    j-=gap;
                }
                j=j+gap;
                array[j] = target;
            }
        }
    }

    private static int  binarySearch(int [] array,int key){
        int low =0;
        int high =array.length-1;
        int middle = (low+high)/2;
        while (low<high){
            if (array[middle]>key){
                high=high-1;
            }else if (array[middle]<key){
                low=low+1;
            }else {
                return middle;
            }
             middle = (low+high)/2;
        }
        return -1;

    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        int[] array = {2, 1, 3, 5, 4, 7, 6, 8, 10, 9, 6};

//        冒泡排序
//        bubbleSort(array);
//        printArray(array);

        //选择排序
//        selectSort(array);
//        printArray(array);

        //插入排序
//        insertSort(array);
//        printArray(array);

        //快速排序
//        quickSort(array, 0, array.length - 1);
//        printArray(array);

        //希尔排序
//        shellSort(array);
//        printArray(array);

        //二分查找
        int index = binarySearch(array, 7);
        System.out.println(index);


    }

}
