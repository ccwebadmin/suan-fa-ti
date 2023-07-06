package com.list;

import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author cc
 * @date 2023/7/6-15:53
 */
public class Sort {
    public static void main(String[] args) {
        List<Person> list1 =new ArrayList<>();
        list1.add(new Person("1号",12, DateUtil.parse("2001-01-01","yyyy-MM-dd")));
        list1.add(new Person("2号",19,DateUtil.parse("2002-01-01","yyyy-MM-dd")));
        list1.add(new Person("3号",13,DateUtil.parse("2003-01-01","yyyy-MM-dd")));
        list1.add(new Person("4号",18,DateUtil.parse("2004-01-01","yyyy-MM-dd")));
        list1.add(new Person("5号",15,DateUtil.parse("2005-01-01","yyyy-MM-dd")));
        list1.add(new Person("6号",17,DateUtil.parse("2006-01-01","yyyy-MM-dd")));
        list1.add(new Person("7号",15,DateUtil.parse("2007-01-01","yyyy-MM-dd")));
        list1.add(new Person("8号",98,DateUtil.parse("2008-01-01","yyyy-MM-dd")));
        list1.add(new Person("9号",15,DateUtil.parse("2009-01-01","yyyy-MM-dd")));
        list1.add(new Person("10号",36,DateUtil.parse("2010-01-01","yyyy-MM-dd")));
        list1.add(new Person("11号",16,DateUtil.parse("2011-01-01","yyyy-MM-dd")));
        list1.add(new Person("12号",45,DateUtil.parse("2012-01-01","yyyy-MM-dd")));
        list1.add(new Person("13号",75,DateUtil.parse("2013-01-01","yyyy-MM-dd")));
        //给list1排序，先按照age倒序排，在按照birthday正序排
        list1.sort(
                Comparator.comparingInt(Person::getAge).reversed()
                        .thenComparing(Comparator.comparing(Person::getBirthday))
        );

        System.out.println(list1);
    }
}
