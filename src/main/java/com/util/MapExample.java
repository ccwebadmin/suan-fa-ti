package com.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {
        // 使用 HashMap 存储键值对
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("A", 10);
        hashMap.put("C", 30);
        hashMap.put("B", 20);
        hashMap.put("C1", 30);
        hashMap.put("B2", 20);
        hashMap.put("C3", 30);
        hashMap.put("B4", 20);


        System.out.println("HashMap elements: " + hashMap);

        Set<Map.Entry<String,Integer>> entrySet = hashMap.entrySet();
        // 迭代输出 HashMap 中的元素输出顺序和上面一致
        for (Map.Entry<String, Integer> entry : entrySet) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " : " + value);
        }

        // 使用 TreeMap 存储键值对
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("A", 10);
        treeMap.put("C1", 30);
        treeMap.put("B2", 20);
        treeMap.put("C3", 30);
        treeMap.put("B4", 20);
        treeMap.put("C5", 30);
        treeMap.put("B6", 20);
        treeMap.put("C7", 30);
        treeMap.put("B8", 20);
        treeMap.put("C9", 30);
        treeMap.put("B", 20);


        System.out.println("TreeMap elements: " + treeMap);
    }
}
