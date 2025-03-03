package com.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.get("1"));
    }

    public static <T, S> T convertor(S source, Class<T> clz, int assignType) throws Exception {
        if (source == null) {
            return null;
        }
        try {
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

}
