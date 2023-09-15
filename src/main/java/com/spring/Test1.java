package com.spring;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author cc
 * @date 2021/12/1-20:05
 */
public class Test1 {

    public static void main(String[] args) {

//        String str = "1";
//        String[] array = str.split(",");
//        List<String> list = new ArrayList<>(Arrays.asList(array));
//
//        System.out.println(list);

//        String str = "1,2,3";
//        String[] array1 = str.split(",");
//
//        System.out.println(Arrays.toString(array1));
//
//
        String[] array = {
                "浙江江南益寿堂医药连锁有限公司衢州柯城",
                "浙江江南益寿堂医药连锁有限公司衢州柯城三衢路药店<浙江江南益寿堂医药连锁有限公司衢州柯城三衢路药店>",
                "浙江江南益寿堂医药连锁有限公司衢州柯城南湖药品行<浙江江南益寿堂医药连锁有限公司衢州柯城南湖药品行>",
                "浙江江南益寿堂医药连锁有限公司衢州柯城县西街大药房<浙江江南益寿堂医药连锁有限公司衢州柯城县西街大药房>",
                "浙江江南益寿堂医药连锁有限公司衢州柯城双港大药房<浙江江南益寿堂医药连锁有限公司衢州柯城双港大药房>",
                "浙江健一行医药零售连锁有限公司衢州柯城逸群分店<浙江健一行医药零售连锁有限公司衢州柯城逸群分店>",
                "浙江健一行医药零售连锁有限公司柯城逸和分店<浙江健一行医药零售连锁有限公司柯城逸和分店>",
                "浙江健一行医药零售连锁有限公司亭川路分店<浙江健一行医药零售连锁有限公司亭川路分店>",
                "衢州市柯城好邻居大药房龙化路店<衢州市柯城好邻居大药房龙化路店>"
        };

        // 创建一个新的数组来存储去掉尖括号之后的结果
        String[] newArray = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            // 使用正则表达式去掉中间尖括号包围的部分
            String result = array[i].replaceAll("<.*?>", "");
            newArray[i] = result;
        }

        System.out.println(Arrays.toString(newArray));

        //        List<String> recpIdList = new ArrayList<>();
//        recpIdList.add("0");
//        recpIdList.add("1");
//        recpIdList.add("2");
//        recpIdList.add("3");
//        recpIdList.add("4");
//        recpIdList.add("5");
//        recpIdList.add("6");
//        recpIdList.add("7");
//        List<List<String>> list1 = Lists.partition(recpIdList, 3);
//
//
//        for (List<String> list : list1) {
//            for (String str : list) {
//                System.out.print(str);
//            }
//            System.out.println();
//        }


//        String commaSeparatedString = recpIdList.stream()
//                .collect(Collectors.joining(","));
//        System.out.println(commaSeparatedString);
//
//
//            List<String>  tempUserIdList = recpIdList.subList(0, 3);
//            for(String str:tempUserIdList){
//                System.out.print(str);
//            }
//        System.out.println();
//        List<String>  tempUserIdList1 = recpIdList.subList(3, 6);
//        for(String str:tempUserIdList1){
//            System.out.print(str);
//        }
//        System.out.println();
//        List<String>  tempUserIdList2 = recpIdList.subList(6, 8);
//        for(String str:tempUserIdList2){
//            System.out.print(str);
//        }
//        System.out.println();
//
//
//
//
//
//        System.out.println("周立龙门浩街道下新街社区<重庆市南岸区医疗保障局>".length());

//        List<Integer> myList = null;
//        System.out.println(myList.size());
//
//
//        myList.add(1);
//        myList.add(2);
//        myList.add(3);
//        myList.add(4);
//        myList.add(5);
//        myList.add(6);
//        myList.add(7);
//        myList.add(8);
//        myList.add(9);
//        myList.add(10);

        // 假设 myList 包含了30个元素
//
//        int batchSize = 3;
//        int totalElements = myList.size();

//        for (int startIndex = 0; startIndex < totalElements; startIndex += batchSize) {
//            int endIndex = Math.min(startIndex + batchSize, totalElements);
//            List<Integer> batch = myList.subList(startIndex, endIndex);
//
//            // 在这里对每个批次的元素进行处理，可以是输出或其他操作
//            System.out.println("Batch: " + batch);
//        }
//        System.out.println(50/100 +1);
//        System.out.println(100/100 +1);
//        System.out.println(150/100 +1);
//
//        List<String> strings = new LinkedList<>();
//        strings.add("");strings.add("is");
//        strings.add(null);
//        System.out.println(String.join(",", strings));

    }

    //    public static void main(String[] args) {
//        String input = "潍坊管理员02<潍坊市医疗保障局>";
//        int index = input.indexOf("<");
//        if (index != -1) {
//            String result = input.substring(0, index);
//            System.out.println("提取出的字符串为: " + result);
//        } else {
//            System.out.println("未找到'<'");
//        }
//    }
    //    public static void main(String[] args) {
//        String payloc =null;
//
//        if (!"3".equals(payloc) && !"4".equals(payloc)) {
//            System.out.println("本地");
//        }
//        System.out.println("3".equals("3"));
//        System.out.println(new BigDecimal("0").setScale(2,BigDecimal.ROUND_HALF_UP));
//        System.out.println(BigDecimal.ZERO.setScale(2,BigDecimal.ROUND_HALF_UP));
//        System.out.println("3304990211203162538007000000".length());
//        System.out.println("20211203164531".length());
//        System.out.println(Test1.ALLATORIxDEMO("$#&#"));
////        String str =null;
////        System.out.println(str.substring(0,1));
//        Map<String, Object> expPara = JSON.parseObject("");
//        if (expPara == null ) {
//            System.out.println("null");
//        }
//        if(isEmpty(expPara)){
//            System.out.println("empty");
//        }
//
//    }
    public static String ALLATORIxDEMO(String s) {
        int var10000 = 2 << 3 ^ 2 ^ 5;
        int var10001 = 5 << 3 ^ 2;
        int var10002 = 2 << 3 ^ 3 ^ 5;
        int var10003 = (s = (String) s).length();
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

        for (int var2 = var10001; var10000 >= 0; var10000 = var3) {
            var10001 = var3;
            char var6 = s.charAt(var3);
            --var3;
            var1[var10001] = (char) (var6 ^ var2);
            if (var3 < 0) {
                break;
            }

            var10002 = var3--;
            var1[var10002] = (char) (s.charAt(var10002) ^ var4);
        }

        return new String(var1);
    }

    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        } else if (value instanceof String) {
            return ((String) value).length() == 0;
        } else if (value instanceof Collection) {
            return ((Collection) value).size() == 0;
        } else if (value instanceof Map) {
            return ((Map) value).size() == 0;
        } else if (value instanceof String[]) {
            return ((String[]) ((String[]) value)).length == 0;
        } else {
            return false;
        }
    }
}
