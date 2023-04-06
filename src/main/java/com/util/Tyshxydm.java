package com.util;

import java.util.Random;

public class Tyshxydm {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String code = generateCode();
            String name = "Company " + code.substring(code.length() - 6);
            System.out.println(code + " " + name);
        }
    }

    private static String generateCode() {
        // Generate a random 18-digit number
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 18; i++) {
            sb.append(random.nextInt(10));
        }
        String code = sb.toString();
        // Add the region code (here we use Beijing's code, you can change it to your desired region)
        // Calculate the check code
        int[] weights = {1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};
        int checkSum = 0;
        for (int i = 0; i < 17; i++) {
            checkSum += (code.charAt(i) - '0') * weights[i];
        }
        int checkCode = (31 - checkSum % 31) % 31;
        if (checkCode == 0) {
            code += "0";
        } else {
            code += String.valueOf(31 - checkSum % 31);
        }
        return code;
    }
}
