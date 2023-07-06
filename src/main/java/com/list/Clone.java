package com.list;

import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cc
 * @date 2023/7/6-15:46
 */
public class Clone {
    public static void main(String[] args) {
        List<Person> list1 =new ArrayList<>();
        list1.add(new Person("1号",12, DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("2号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("3号",13,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("4号",14,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("5号",15,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("6号",16,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("7号",15,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("8号",16,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("9号",15,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("10号",16,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("11号",16,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("12号",15,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("13号",15,DateUtil.parse("2003-01-01","yyyy-MM-dd")));

        //从list1找出age是15的，姓名包含1的生成新的list2
        List<Person> list2 = list1.stream()
                .filter(person -> person.getAge() == 15)
                .filter(person -> person.getName().contains("1"))
                .collect(Collectors.toList());

        System.out.println(list2);
    }
}
