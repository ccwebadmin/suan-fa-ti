package com.leetcode1.com.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItretorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        //写法1
        list.removeIf("a"::equals);
        //写法2
//        list.removeIf(s -> s.equals("a"));
        //写法3
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()){
//            if("a".equals(it.next())){
//                it.remove();
//            }
//        }

        //迭代器会删除list中元素
        for (String str : list) {
            System.out.println(str);
        }
    }
}
