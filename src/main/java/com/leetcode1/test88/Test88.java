package com.leetcode1.test88;

/**
 *
 * 88. 合并两个有序数组
 */
public class Test88 {
    public static void main(String[] args) {
         int[] nums1= {1,2,3};
         int[] nums2= {2,4,5};
        Test88 test = new Test88();
        test.merge(nums1,nums1.length,nums2,nums2.length);
//        System.out.println(nums1.toString());
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 参数有效性检查
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Input arrays cannot be null.");
        }
        if (m < 0 || m > nums1.length || n < 0 || n > nums2.length) {
            throw new IllegalArgumentException("Invalid values for m or n.");
        }

        // 合并逻辑
        int p1 = m - 1; // nums1 的最后一个有效元素索引
        int p2 = n - 1; // nums2 的最后一个有效元素索引
        int index = nums1.length - 1; // 合并后数组的最后一个位置

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[index--] = nums1[p1--];
            } else {
                nums1[index--] = nums2[p2--];
            }
        }

        // 如果 nums2 还有剩余元素，则直接复制
        while (p2 >= 0) {
            nums1[index--] = nums2[p2--];
        }
    }


}
