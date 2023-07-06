package com.list;

import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cc
 * @date 2023/7/6-15:33
 */

public class CombineDistinct {
    //拼接后元素去重
    public static void main(String[] args) {
        List<Person> list1 =new ArrayList<>();
        list1.add(new Person("1号",12, DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("2号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("3号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));


        List<Person> list2 =new ArrayList<>();

        list2.add(new Person("4号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list2.add(new Person("5号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list2.add(new Person("6号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list2.add(new Person("2号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list2.add(new Person("3号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list2.add(new Person("9号",12,DateUtil.parse("2003-01-01","yyyy-MM-dd")));



        //如过要返回一个全新的list3是拼接的
        List<Person> list3 =new ArrayList<>(list1);
        list3.addAll(list2);

        //此时list3是拼接过后的list
        System.out.println(list3);

        //list3中去重 返回的list4是去重的
        List<Person> list4 =  list3.stream().distinct().collect(Collectors.toList());
        System.out.println(list4);

    }


}
