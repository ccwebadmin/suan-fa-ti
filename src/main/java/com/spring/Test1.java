package com.spring;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

/**
 * @author cc
 * @date 2021/12/1-20:05
 */
public class Test1 {
    public static void main(String[] args) {
        String payloc =null;

        if (!"3".equals(payloc) && !"4".equals(payloc)) {
            System.out.println("本地");
        }
        System.out.println("3".equals("3"));
        System.out.println(new BigDecimal("0").setScale(2,BigDecimal.ROUND_HALF_UP));
        System.out.println(BigDecimal.ZERO.setScale(2,BigDecimal.ROUND_HALF_UP));
        System.out.println("3304990211203162538007000000".length());
        System.out.println("20211203164531".length());
        System.out.println(Test1.ALLATORIxDEMO("$#&#"));
//        String str =null;
//        System.out.println(str.substring(0,1));
        Map<String, Object> expPara = JSON.parseObject("");
        if (expPara == null ) {
            System.out.println("null");
        }
        if(isEmpty(expPara)){
            System.out.println("empty");
        }

    }
    public static String ALLATORIxDEMO(String s) {
        int var10000 = 2 << 3 ^ 2 ^ 5;
        int var10001 = 5 << 3 ^ 2;
        int var10002 = 2 << 3 ^ 3 ^ 5;
        int var10003 = (s = (String)s).length();
        char[] var10004 = new char[var10003];
        boolean var10006 = true;
        int var5 = var10003 - 1;
        var10003 = var10002;
        int var3;
        var10002 = var3 = var5;
        char[] var1 = var10004;
        int var4 = var10003;
        var10001 = var10000;
        var10000 = var10002;

        for(int var2 = var10001; var10000 >= 0; var10000 = var3) {
            var10001 = var3;
            char var6 = s.charAt(var3);
            --var3;
            var1[var10001] = (char)(var6 ^ var2);
            if (var3 < 0) {
                break;
            }

            var10002 = var3--;
            var1[var10002] = (char)(s.charAt(var10002) ^ var4);
        }

        return new String(var1);
    }

    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        } else if (value instanceof String) {
            return ((String)value).length() == 0;
        } else if (value instanceof Collection) {
            return ((Collection)value).size() == 0;
        } else if (value instanceof Map) {
            return ((Map)value).size() == 0;
        } else if (value instanceof String[]) {
            return ((String[])((String[])value)).length == 0;
        } else {
            return false;
        }
    }
}
