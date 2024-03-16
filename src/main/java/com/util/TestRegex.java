package com.util;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TestRegex {
    public static void main(String[] args) {

        String aa="servitem_type,techcnt,risk_deg,mediType,medMcsType,psn_lv,psn_type,drug_type,SCHG_FLAG,OPRN_FLAG,MGT_FOM,hosp_lv";

        System.out.println(aa.toUpperCase());
//        String url = "http://10.1.50.244/group1/M00/00/12/CgEy9GWGfSSAZ8IdAAAEsDcKiJc003.pdf";
//        url= url.replaceFirst(":\\d+", "");
//        System.out.println(url);
//
//        String url1 = "http://10.1.50.244:222/group1/";
//        System.out.println(url1.endsWith("/"));
//
//        JSONObject bizParam = new JSONObject();
//        bizParam.put("listId", "11222");
//        bizParam.put("servitemId", "22222");
//        bizParam.put("ver", "3333");
//        System.out.println(bizParam.toJSONString());

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add("grape");
        list.add("cherry");

        String target = "orange";

        // 创建一个新的ArrayList来保存满足条件的元素
        List<String> resultList = new ArrayList<>();

        // 从原始列表中移除满足条件的元素，并保存到新的列表中
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals(target)) {
                iterator.remove();
                resultList.add(item);
            }
        }

        // 将满足条件的元素添加到列表的最后
        list.addAll(resultList);

        System.out.println(list);
//        for(String str:list){
//            if("banana".equals(str)){
//                list.remove(str);
//            }
//            System.out.println(str);
//        }

        Iterator<String> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            String item = iterator1.next();
            if (item.equals("banana")) {
                iterator1.remove();
            }
            if (item.equals("orange")) {
                iterator1.remove();
            }
            System.out.println(list);
        }
    }

}
