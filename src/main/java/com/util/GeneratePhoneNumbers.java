package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author cc
 * @Date 2025年04月15日 10:05
 */
public class GeneratePhoneNumbers {
    public static void main(String[] args) {
        List<String> phoneNumbers = generatePhoneNumbers(100);
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }

    public static List<String> generatePhoneNumbers(int count) {
        List<String> numbers = new ArrayList<>();
        Random random = new Random();
        // 手机号码第二位可能的数字
        int[] secondDigits = {3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < count; i++) {
            StringBuilder phoneNumber = new StringBuilder("1");
            // 随机选择第二位数字
            phoneNumber.append(secondDigits[random.nextInt(secondDigits.length)]);

            // 生成后面 9 位数字
            for (int j = 0; j < 9; j++) {
                phoneNumber.append(random.nextInt(10));
            }
            numbers.add(phoneNumber.toString());
        }
        return numbers;
    }
}
