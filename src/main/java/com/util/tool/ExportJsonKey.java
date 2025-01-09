package com.util.tool;

import cn.hutool.core.io.file.FileWriter;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ExportJsonKey {
    public static void main(String[] args) {
        String jsonString = "{\"code\": 0,   \"type\": \"success\",   \"message\": \"成功\",   \"data\": {     \"rows\": [       {         \"pageNum\": 1,         \"pageSize\": 20,         \"isPage\": \"1\",         \"taskId\": null,         \"taskType\": null,         \"servitemId\": \"2024111209021344000020006954\",         \"evtsn\": null,         \"tempCode\": null,         \"nodeType\": null,         \"stdCode\": null,         \"stdName\": \"心脏搭桥手术\",         \"applyStartDate\": null,         \"applyEndDate\": null,         \"updtTime\": \"2024-11-12 09:02:24\",         \"appyDate\": null,         \"appyDateStr\": null,         \"servitemType\": null,         \"servitemTypeArr\": null,         \"servitemTypeName\": null,         \"appyPoolarea\": null,         \"appyPoolareaName\": null,         \"poolareaNo\": null,         \"appyMedinsId\": null,         \"appyMedinsName\": null,         \"isDeclare\": null,         \"crterName\": \"服务价格地方端测试账号\",         \"opterName\": \"服务价格地方端测试账号\",         \"crtNodeName\": null,         \"declareStatus\": null,         \"admdvs\": null,         \"admdvsName\": null,         \"chkFlag\": null,         \"guidpric\": null,         \"dspoOpnn\": null,         \"deptName\": null,         \"ver\": \"7\",         \"decFlag\": null,         \"issueFlag\": null,         \"extCallFlag\": null,         \"modiId\": null,         \"state\": null,         \"stateName\": null,         \"remark\": null,         \"convStateName\": null,         \"pricWay\": null,         \"loclCode\": null,         \"fbckAdv\": null,         \"fbckAdvDscr\": null,         \"reportTime\": null,         \"mergServitemId\": null,         \"fbckAdvName\": null,         \"soucFlag\": null,         \"fileSyncflag\": null,         \"bchno\": null,         \"exePric\": null,         \"btchName\": null,         \"servOupt\": null,         \"pricDscr\": null,         \"memo\": null,         \"servitemExctCont\": null,         \"tcmServitemFlag\": null,         \"tcmServitemFlagName\": null,         \"nodeList\": null,         \"endDate\": null,         \"startDate\": null,         \"servitemEvtId\": null       },       {         \"pageNum\": 1,         \"pageSize\": 20,         \"isPage\": \"1\",         \"taskId\": null,         \"taskType\": null,         \"servitemId\": \"2024111209021344000020006954\",         \"evtsn\": null,         \"tempCode\": null,         \"nodeType\": null,         \"stdCode\": null,         \"stdName\": \"心脏搭桥手术\",         \"applyStartDate\": null,         \"applyEndDate\": null,         \"updtTime\": \"2024-11-12 09:02:24\",         \"appyDate\": null,         \"appyDateStr\": null,         \"servitemType\": null,         \"servitemTypeArr\": null,         \"servitemTypeName\": null,         \"appyPoolarea\": null,         \"appyPoolareaName\": null,         \"poolareaNo\": null,         \"appyMedinsId\": null,         \"appyMedinsName\": null,         \"isDeclare\": null,         \"crterName\": \"服务价格地方端测试账号\",         \"opterName\": \"服务价格地方端测试账号\",         \"crtNodeName\": null,         \"declareStatus\": null,         \"admdvs\": null,         \"admdvsName\": null,         \"chkFlag\": null,         \"guidpric\": null,         \"dspoOpnn\": null,         \"deptName\": null,         \"ver\": \"6\",         \"decFlag\": null,         \"issueFlag\": null,         \"extCallFlag\": null,         \"modiId\": null,         \"state\": null,         \"stateName\": null,         \"remark\": null,         \"convStateName\": null,         \"pricWay\": null,         \"loclCode\": null,         \"fbckAdv\": null,         \"fbckAdvDscr\": null,         \"reportTime\": null,         \"mergServitemId\": null,         \"fbckAdvName\": null,         \"soucFlag\": null,         \"fileSyncflag\": null,         \"bchno\": null,         \"exePric\": null,         \"btchName\": null,         \"servOupt\": null,         \"pricDscr\": null,         \"memo\": null,         \"servitemExctCont\": null,         \"tcmServitemFlag\": null,         \"tcmServitemFlagName\": null,         \"nodeList\": null,         \"endDate\": null,         \"startDate\": null,         \"servitemEvtId\": null       }     ],     \"pageInfo\": {       \"pageNum\": 1,       \"pageSize\": 10,       \"size\": 7,       \"startRow\": 1,       \"endRow\": 7,       \"pages\": 1,       \"recordCounts\": 7,       \"prePage\": 0,       \"nextPage\": 0,       \"orderField\": null,       \"orderType\": null,       \"lastPage\": true,       \"firstPage\": true     },     \"hsafLogHandler\": null   } }"; // 这里放置你的JSON字符串
        Set<String> keys = extractKeys(new JSONObject(jsonString), "");

        FileWriter writer = new FileWriter("D://keys.txt");
        int index = 1;
        for (String key : keys) {
            writer.write(index + ". " + key + "\n");
            index++;
        }
    }

    private static Set<String> extractKeys(JSONObject jsonObject, String prefix) {
        Set<String> keys = new HashSet<>();
        for (String key : jsonObject.keySet()) {
            String fullKey = prefix.isEmpty() ? key : prefix + "." + key;
            Object value = jsonObject.get(key);
            if (value instanceof JSONObject) {
                keys.addAll(extractKeys((JSONObject) value, fullKey));
            } else if (value instanceof JSONArray) {
                keys.add(fullKey + " array");
                JSONArray jsonArray = (JSONArray) value;
                for (int i = 0; i < jsonArray.size(); i++) {
                    if (jsonArray.get(i) instanceof JSONObject) {
                        keys.addAll(extractKeys((JSONObject) jsonArray.get(i), fullKey + "[" + i + "]"));
                    }
                }
            } else {
                keys.add(fullKey);
            }
        }
        return keys;
    }

}
