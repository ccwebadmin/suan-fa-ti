package com.leetcode1.test1to100;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author cc
 * @date 2025年09月25日 10:43
 * @return
 */
public class Test88 {
    /**
     * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6]
     * 输出：[1,2,2,3,5,6]
     * 提示：
     * 1 <= nums1.length == m + n <= 2000
     * 1 <= nums2.length == n <= 2000
     * 0 <= nums1[i], nums2[i] <= 100
     * 考虑 nums1 的空间，将 nums2 合并到 nums1 中。
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge2(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
        
        // 演示int数组转换为Integer数组的几种方法
        demonstrateIntToIntegerConversion();
    }
    
    public static void demonstrateIntToIntegerConversion() {
        System.out.println("=== int数组转换为Integer数组的几种方法 ===");
        int[] intArray = {5, 2, 8, 1, 9};
        
        // 方法1：使用Stream API (Java 8+)
        System.out.println("方法1：使用Stream API");
        Integer[] integerArray1 = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        System.out.println("转换结果：" + Arrays.toString(integerArray1));
        
        // 方法2：使用循环手动转换
        System.out.println("方法2：使用循环手动转换");
        Integer[] integerArray2 = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            integerArray2[i] = intArray[i]; // 自动装箱
        }
        System.out.println("转换结果：" + Arrays.toString(integerArray2));
        
        // 方法3：使用IntStream的mapToObj方法
        System.out.println("方法3：使用IntStream的mapToObj方法");
        Integer[] integerArray3 = IntStream.of(intArray).boxed().toArray(Integer[]::new);
        System.out.println("转换结果：" + Arrays.toString(integerArray3));
        
        // 现在可以对Integer数组使用带比较器的排序方法
        System.out.println("对Integer数组进行倒序排序：");
        Arrays.sort(integerArray1, (a, b) -> b - a);
        System.out.println("倒序排序结果：" + Arrays.toString(integerArray1));
    }
    
    //方法1：双指针，时间复杂度O(m+n)
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        //数组下标
        int i = m - 1;
        int j = n - 1;
        //比较大小
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[i + j + 1] = nums1[i--];
            }else {
                nums1[i + j + 1] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[j] = nums2[j--];
        }
        while (i >= 0) {
            nums1[i] = nums1[i--];
        }
    }

    //方法2：使用系统函数
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        //数组拷贝 将源nums2从0号位开始拷贝到nums1的m号位，长度为n
        System.arraycopy(nums2, 0, nums1, m, n);
        //排序 升序
        Arrays.sort(nums1);
        
        
        //下面是补充！！！
        //注意：int[]数组不能直接使用带比较器的sort方法
        //如果需要倒序，可以：
        // 1. 使用循环反转数组
        for (int i = 0; i < nums1.length / 2; i++) {
            int temp = nums1[i];
            nums1[i] = nums1[nums1.length - i - 1];
            nums1[nums1.length - i - 1] = temp;
        }
        
        // 2. 转换为Integer[]数组再排序
        //nums1 数组转为integer[] 数组
        Integer[] integerArray1 = Arrays.stream(nums1).boxed().toArray(Integer[]::new);
        //倒序排序
        Arrays.sort(integerArray1, (a, b) -> b - a);
        
    }
}
