package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tyshxydm {
    private static final String BASE_CODE_STRING = "0123456789ABCDEFGHJKLMNPQRTUWXY";
    private static final int[] WEIGHTS = {1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};

    public static void main(String[] args) {
        List<String> codes = generateCodes(100);
        for (String code : codes) {
            System.out.println(code);
        }
    }

    public static List<String> generateCodes(int count) {
        List<String> codeList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            StringBuilder pre17 = new StringBuilder();
            for (int j = 0; j < 17; j++) {
                int index = random.nextInt(BASE_CODE_STRING.length());
                pre17.append(BASE_CODE_STRING.charAt(index));
            }
            char checkCode = calculateCheckCode(pre17.toString());
            String code = pre17.toString() + checkCode;
            codeList.add(code);
        }
        return codeList;
    }

    private static char calculateCheckCode(String pre17) {
        int total = 0;
        for (int i = 0; i < 17; i++) {
            char c = pre17.charAt(i);
            int index = BASE_CODE_STRING.indexOf(c);
            total += index * WEIGHTS[i];
        }
        int remainder = 31 - total % 31;
        if (remainder == 31) {
            remainder = 0;
        }
        return BASE_CODE_STRING.charAt(remainder);
    }
}
