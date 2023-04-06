package com.util;

import java.util.LinkedHashMap;

/**
 * @author cc
 * @date 2023/3/31-17:16
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16, 0.75f, false);
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        map.put("f", 6);
        map.put("g", 7);
        map.put("h", 8);
        map.put("i", 9);
        for (String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
