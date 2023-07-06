package com.util;

import com.prac.SelSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cc
 * @date 2023/6/14-20:03
 */
public class Test  extends SelSort {
    public static void main(String[] args) throws InterruptedException {
//        List<String> list = new ArrayList<>();
//        list.add("Existing Data 1");
//        list.add("Existing Data 2");
//
//        list.add(0, "New Data");
//
//        System.out.println(list);
        System.out.println(3*0.1==0.3);
        methodA();
        Thread.sleep(30000);
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


