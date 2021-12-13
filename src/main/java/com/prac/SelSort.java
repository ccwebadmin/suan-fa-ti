package com.prac;

import java.util.Random;

/**
 * 选择排序
 *
 * @author cc
 * @date 2021/12/13-16:58
 */
public class SelSort {
    public static void main(String[] args) throws Exception {
        int[] arr = genArray(10000, 10000);
        long time1 =System.currentTimeMillis();
        System.out.println(time1);
        printArray(arr);
        selSortM(arr);
        printArray(arr);
        long time2 =System.currentTimeMillis();
        System.out.println(time2);
        System.out.println("耗时："+(time2-time1));
    }

    //生成指定长度的整数数组
    public static int[] genArray(int maxNum, int length) throws Exception {
        Random random = new Random();
        int arr[] = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(maxNum);
        }
        return arr;
    }

    //数组打印
    public static void printArray(int[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i] + "");
            } else {
                sb.append(arr[i]).append(",");
            }
        }
        System.out.println(sb.toString());
    }

    //选择排序
    public static void selSortM(int arr[]) {
        for (int i = 0; i < arr.length-1;i++){
            int min =i;
             for( int j=i+1;j< arr.length;j++){
                 if (arr[j]<arr[min]){
                     min =j;
                 }
             }
             if(i!=min){
                 int temp =arr[i];
                 arr[i]=arr[min];
                 arr[min] = temp;
             }
        }
    }

}
