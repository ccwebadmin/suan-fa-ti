package com.util.test;

import java.util.Arrays;

public class CustomArrayCopyExample {
    public static void main(String[] args) {
        String[] originalArray = {"Apple", "Banana", "Cherry"};
        // 复制并指定新数组类型
        String[] copiedArray = Arrays.copyOf(originalArray, 5, String[].class);
        copiedArray[1] ="xxx";
        System.out.println(Arrays.toString(copiedArray));
        System.out.println(Arrays.toString(originalArray));
    }
}
