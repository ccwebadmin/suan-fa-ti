package com.threeEachDay.day20240308.test1;

import java.util.Arrays;

public class Test2024030801 {
    public static void main(String[] args) {
        int[] A =new int[]{1,2,3,4,5};

        int[] B =new int[]{7,5,2,8};
        findMissingNumbersTraversal(A,B);

    }

    /**
     * m1:双重遍历
     */
    public static void findMissingNumbersTraversal(int[] A, int[] B) {
        for (int num : B) {
            boolean found = false;
            for (int i : A) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(num);
            }
        }
    }

    /**
     * 二分法
     */
    public void findMissingNumbersBinarySearch(int[] A, int[] B) {
        //这步多余A是有序的
        Arrays.sort(A);
        for (int num : B) {
            //二分查找找不到返回-1
            if (Arrays.binarySearch(A, num) < 0) {
                System.out.println(num);
            }
        }
    }
    public void findMissingNumbersSortMerge(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                System.out.println(B[j]);
                j++;
            }
        }
        while (j < B.length) {
            System.out.println(B[j]);
            j++;
        }
    }

}
