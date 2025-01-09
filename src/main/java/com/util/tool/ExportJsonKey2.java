package com.util.tool;

import cn.hutool.core.io.file.FileWriter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExportJsonKey2 {
    public static void main(String[] args) {
        String jsonString = "{...}"; // 这里放置你的JSON字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonString);
            Set<String> keys = extractKeys(rootNode, "");

            FileWriter writer = new FileWriter("d://keys.txt");
            int index = 1;
            for (String key : keys) {
                writer.write(index + ". " + key + "\n");
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> extractKeys(JsonNode node, String prefix) {
        Set<String> keys = new HashSet<>();
        if (node.isObject()) {
            for (Iterator<String> it = node.fieldNames(); it.hasNext(); ) {
                String key = it.next();
                String fullKey = prefix.isEmpty() ? key : prefix + "." + key;
                keys.addAll(extractKeys(node.get(key), fullKey));
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                String fullKey = prefix + "[" + i + "]";
                keys.addAll(extractKeys(node.get(i), fullKey));
            }
        } else {
            keys.add(prefix);
        }
        return keys;
    }
}
