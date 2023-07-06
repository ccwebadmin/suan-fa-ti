package com.list;

import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * list拼接
 * @author cc
 * @date 2023/7/6-15:13
 */
public class Combine {

    public static void main(String[] args) {
        List<Person> list1 =new ArrayList<>();
        list1.add(new Person("1号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("2号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("3号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));


        List<Person> list2 =new ArrayList<>();

        list2.add(new Person("4号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list2.add(new Person("5号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list2.add(new Person("6号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list2.add(new Person("7号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list2.add(new Person("8号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list2.add(new Person("9号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));

        //将两个list不去重拼接
        list1.addAll(list2);
        //此时list1是拼接过后的list
        System.out.println(list1);


        //如过要返回一个全新的list3是拼接的
        List<Person> list3 =new ArrayList<>(list1);
        list3.addAll(list2);

        //此时list3是拼接过后的list
        System.out.println(list3);

    }

}
