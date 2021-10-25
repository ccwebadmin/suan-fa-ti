package com.leetcode1.com.other;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;



public class toJsonString {

    public static void main(String[] args) {
        JSONObject object = new JSONObject();

        object.put("certno","12321312312");
        object.put("psn_name","黄峰");
        object.put("psn_cert_type","01");
        System.out.println(JSON.toJSONString(object));
    }

}
