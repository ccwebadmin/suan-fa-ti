package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author cc
 * @Date 2025年04月15日 10:03
 */
public class GenerateName {
    private static final String[] SUR_NAMES = {
            "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈",
            "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
            "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏",
            "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章",
            "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦",
            "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
            "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺",
            "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常",
            "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余",
            "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹"
    };
    private static final String[] FIRST_NAMES = {
            "伟", "芳", "娜", "敏", "静", "强", "磊", "军", "洋", "勇",
            "艳", "杰", "娟", "涛", "明", "超", "秀", "霞", "慧", "健",
            "婷", "俊", "子", "萱", "梓", "涵", "诗", "涵", "嘉", "怡",
            "晨", "晨", "紫", "涵", "诗", "涵", "嘉", "怡", "晨", "晨"
    };

    public static void main(String[] args) {
        List<String> names = generateNames(100);
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static List<String> generateNames(int count) {
        List<String> names = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String surName = SUR_NAMES[random.nextInt(SUR_NAMES.length)];
            int nameLength = random.nextInt(2) + 1;
            StringBuilder name = new StringBuilder(surName);
            for (int j = 0; j < nameLength; j++) {
                name.append(FIRST_NAMES[random.nextInt(FIRST_NAMES.length)]);
            }
            names.add(name.toString());
        }
        return names;
    }
}
