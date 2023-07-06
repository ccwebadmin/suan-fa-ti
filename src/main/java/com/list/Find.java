package com.list;

import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author cc
 * @date 2023/7/6-15:38
 */
public class Find {
    //找出某个元素第一次出现的位置
    public static void main(String[] args) {
        List<Person> list1 =new ArrayList<>();
        list1.add(new Person("1号",12, DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("2号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("3号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("2号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("3号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));

        String targetName = "3号";

        OptionalInt firstIndex = IntStream.range(0, list1.size())
                .filter(i -> list1.get(i).getName().equals(targetName))
                .findFirst();

        if (firstIndex.isPresent()) {
            System.out.println("第一次出现的位置索引为: " + firstIndex.getAsInt());
        } else {
            System.out.println("未找到指定名称的元素");
        }
    }
}
