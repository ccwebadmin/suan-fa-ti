package com.util;

import com.prac.SelSort;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author cc
 * @date 2023/6/14-20:03
 */
public class Test  extends SelSort {
    public static void main(String[] args) throws InterruptedException {

        // 时间戳 后面拼接流水号 如果需要 可以加上时分秒
        String datetime = new SimpleDateFormat("yyyyMMdd").format(new Date());
        // 这里是 Redis key的前缀，如: sys:表名:日期 如果不需要去掉表名也可以
        String key = MessageFormat.format("{0}:{1}:{2}:{3}", "ips", "admin", "impuser", datetime);
        System.out.println(key);
//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String element = iterator.next();
//            if (element.equals("B")) {
//                iterator.remove(); // 删除元素
//            }
//        }
//
//        Iterator<String> iterator2 = list.iterator();
//        while (iterator2.hasNext()) {
//            String element = iterator2.next();
//            System.out.println(element);
//        }
//        List<String> list = new ArrayList<>();
//        list.add("Existing Data 1");
//        list.add("Existing Data 2");
//
//        list.add(0, "New Data");
//
//        System.out.println(list);
//        System.out.println(3*0.1==0.3);
//        methodA();
//        Thread.sleep(30000);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public  static void methodA(){
        MyResource myResource =new MyResource();
        System.out.println(myResource);
    }
}


