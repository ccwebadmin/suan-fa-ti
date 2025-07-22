package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author cc
 * @Date 2025年04月15日 10:09
 */
public class GenerateDomesticEmailAddresses {
    private static final String[] DOMAINS = {
            "qq.com", "163.com", "126.com", "sina.com", "sohu.com", "yeah.net"
    };
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) {
        List<String> emailAddresses = generateEmailAddresses(100);
        for (String email : emailAddresses) {
            System.out.println(email);
        }
    }

    public static List<String> generateEmailAddresses(int count) {
        List<String> emailList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            StringBuilder username = new StringBuilder();
            int usernameLength = random.nextInt(5) + 3; // 用户名长度 3 - 7 位
            for (int j = 0; j < usernameLength; j++) {
                int index = random.nextInt(CHAR_SET.length());
                username.append(CHAR_SET.charAt(index));
            }
            String domain = DOMAINS[random.nextInt(DOMAINS.length)];
            String email = username + "@" + domain;
            emailList.add(email);
        }
        return emailList;
    }
}
