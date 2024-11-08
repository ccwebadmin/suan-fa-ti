package com.util.test;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        // 创建一个 HashSet
        HashSet<String> set = new HashSet<>();

        // 添加元素
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // 重复的元素会被忽略,只会有一个Apple
        set.add(null);
        set.add(null); // 重复的元素会被忽略,只会有一个null
        // 输出集合大小
        System.out.println("Set size: " + set.size()); // 输出: Set size: 3

        // 检查元素是否存在
        System.out.println("Contains 'Apple': " + set.contains("Apple")); // 输出: Contains 'Apple': true
        System.out.println("Contains 'Grape': " + set.contains("Grape")); // 输出: Contains 'Grape': false

        // 删除元素
        set.remove("Banana");
        System.out.println("Set after removing 'Banana': " + set); // 输出: Set after removing 'Banana': [Apple, Cherry]

        // 遍历集合
        System.out.println("Iterating through the set:");
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // 使用 Iterator 遍历集合
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        // 清空集合
        set.clear();
        System.out.println("Set after clearing: " + set); // 输出: Set after clearing: []
    }
}
