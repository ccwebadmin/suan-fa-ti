package com.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateStrTest {
    /**
     * 根据字符串长度的不同情况，在字符串前面拼接不同的日期格式。
     *
     * @param input 输入字符串
     * @return 拼接日期后的字符串
     */
    public static String prependDateBasedOnLength(String input) {
        int length = input.length();
        System.out.println(length);

        if (length > 0 && length <= 26) {
            // 拼接年月日时分秒
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + input;
        } else if (length > 26 && length <= 32) {
            // 拼接年月日
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + input;
        } else {
            // 32位以上无变化
            return input;
        }
    }

    public static void main(String[] args) {
        // 测试方法
        System.out.println(prependDateBasedOnLength("abc")); // 长度为3
        System.out.println(prependDateBasedOnLength("12345678901234567890123456")); // 长度为26
        System.out.println(prependDateBasedOnLength("1234567890123456789012345678902233")); // 长度为30
        System.out.println(prependDateBasedOnLength("12345678901234567890123456789012345678901234567890")); // 长度为32
        System.out.println(prependDateBasedOnLength("123456789012345678901234567890123456789012345678901234567890")); // 长度为33
    }
}
