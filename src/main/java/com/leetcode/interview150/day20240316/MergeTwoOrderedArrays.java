package com.leetcode.interview150.day20240316;

import java.util.Arrays;

public class MergeTwoOrderedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,5,9,0,0,0};
        int m =3;
        int[] nums2 = new int[]{2,5,8};
        int n =3;
//        merge1(nums1,m,nums2,n);
//        for(int num :nums1) {
//            System.out.print(num);
//        }

//        merge2(nums1,m,nums2,n);
//        for(int num :nums1) {
//            System.out.print(num);
//        }

        merge3(nums1,m,nums2,n);
        for(int num :nums1) {
            System.out.print(num);
        }
    }

    //数组合并后排序
    //快排时间复杂度 O((m+n)log(m+n))
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i] =nums2[i];
        }
        Arrays.sort(nums1);
    }

    //双指针法 ，前提是有序
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] sortNum =new int[m+n];
        int p1=0,p2=0;
        int cur =0;
        while(p1<m|| p2<n){
            if(p1==m){
                cur =nums2[p2++];
            }else if (p2==n){
                cur =nums1[p1++];
            }else if(nums1[p1]<=nums2[p2]){
                cur =nums1[p1++];
            }else{
                cur = nums2[p2++];
            }
            sortNum[p1+p2-1]=cur;
        }
        //按要求给nums1赋值
        for (int i = 0; i < sortNum.length; i++) {
            nums1[i]=sortNum[i];
        }
    }

    //从后往前的双向逆时针,可以避免使用新的数组
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        //指针初始位置
        int p1=m-1;
        int p2=n-1;
        int total = m+n-1;
        while(p1>-1 || p2> -1){
            if(p1==-1){
                nums1[total--] =nums2[p2--];
            } else if (p2==-1) {
                nums1[total--] =nums1[p1--];
            }else if(nums1[p1]>=nums2[p2]){
                nums1[total--] =nums1[p1--];
            }else{
                nums1[total--] =nums2[p2--];
            }
        }
    }
}
