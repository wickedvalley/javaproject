package com.writecode;

/**
 * Created by MinZeng
 * 时间：2018/9/22.
 */
public class NgeArray {


    //3 4 1 100
    //4 100 100 -1
    private static int[] getNgeArray(int[] originArray) {
        for (int i=0;i<originArray.length;i++) {
            boolean isExistBigger = false;
            for (int j=i+1;j<originArray.length;j++){
                if (originArray[j]>originArray[i]){
                    isExistBigger =true;
                    originArray[i] = originArray[j];
                    break;
                }
            }
            if (!isExistBigger){
                originArray[i]= -1;
            }
        }
        return originArray;
    }


    public static void main(String[] args) {
        int [] array = {5,4,3,2,1};


        int [] result = getNgeArray(array);

        for (int i :result){
            System.out.print(i+" ");
        }

    }


}
