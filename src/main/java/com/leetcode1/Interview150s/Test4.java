package com.leetcode1.Interview150s;

/**
 *
 * @author cc
 * @date 2025年09月19日 14:03
 * @return
 */
public class Test4 {
    public static void main(String[] args) {
        //数组1
        int[] nums1 = {1, 2, 2, 3};
        //有序数组2
        int[] nums2 = {2, 2, 3, 4, 5};
        Test4 test4 = new Test4();
        System.out.println(test4.findMedianSortedArrays(nums1,nums2));
    }
    
    //合并两个有序数组，并生成一个新的数组，并返回中位数
    public double findMedianSortedArrays(int[] nums1,  int[] nums2) { 
        //长度
        int m = nums1.length;
        int n = nums2.length;
        // 新数组
        int[] newNums = new int[m + n];
        // 下标
        int p1 = m - 1;
        int p2 = n - 1;
        int index = m+n- 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                newNums[index--] = nums1[p1--];
            } else {
                newNums[index--] = nums2[p2--];
            }
        }
        while (p1 >= 0) {
            newNums[index--] = nums1[p1--];
        }
        while (p2 >= 0) {
            newNums[index--] = nums2[p2--];
        }
        int n1 = newNums.length;
        if (n1 % 2 == 1) {
            return newNums[n1 / 2];
        } else {
            return (newNums[n1 / 2 - 1] + newNums[n1 / 2]) / 2.0;
        }
    }

}
