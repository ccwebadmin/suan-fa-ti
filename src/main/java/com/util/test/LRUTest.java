package com.util.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUTest<K, V> extends LinkedHashMap<K, V> {
    private final int cacheSize;
    public LRUTest(int cacheSize) {
        // super(cacheSize, 0.75f, true) 中的 true 表示按访问顺序
        super(cacheSize, 0.75f, true);
        this.cacheSize = cacheSize;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当缓存大小超过 cacheSize 时，返回 true 表示移除最老的条目
        return size() > cacheSize;
    }
    public static void main(String[] args) {
        LRUTest<Integer, String> cache = new LRUTest<>(3);
        // 插入数据
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        // 访问数据，使其成为最近使用的
        System.out.println(cache.get(1)); // 输出: One
        // 插入新数据，导致缓存满
        cache.put(4, "Four");
        // 查看缓存内容
        System.out.println(cache); // 输出: {1=One, 3=Three, 4=Four}
        // 访问数据，使其成为最近使用的
        System.out.println(cache.get(3)); // 输出: Three
        // 插入新数据，导致缓存满
        cache.put(5, "Five");
        // 查看缓存内容
        System.out.println(cache); // 输出: {3=Three, 4=Four, 5=Five}
    }
}
