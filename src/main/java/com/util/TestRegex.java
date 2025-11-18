package com.util;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestRegex {
    public static final String REG_NUMBER = "^[0-9]+(.[0-9]+)?$";
    public static void main(String[] args) {
//        String str1 = "456789.";
//        System.out.println(str1.matches(REG_NUMBER)?"是":"否");
//        System.out.println(new BigDecimal(str1));
//
//        String str2 = "456789.11";
//        System.out.println(str2.matches(REG_NUMBER)?"是":"否");
//        System.out.println(new BigDecimal(str2));
//
//        String str3 = "456789";
//        System.out.println(str3.matches(REG_NUMBER)?"是":"否");
//        System.out.println(new BigDecimal(str3));
//
//        String str4 = "0.11";
//        System.out.println(str4.matches(REG_NUMBER)?"是":"否");
//        System.out.println(new BigDecimal(str4));
//
//        String str5 = "-0.11";
//        System.out.println(str5.matches(REG_NUMBER)?"是":"否");
//        System.out.println(new BigDecimal(str5));


        String str6 = "112到啊1223";
        System.out.println(str6.matches(REG_NUMBER)?"是":"否");
        System.out.println(new BigDecimal(str6));
    }

}
