package com.util;

/**
 *
 * @author cc
 * @date 2025年11月27日 17:08
 * @return
 */
public class Test111 {
    //写一个回文串算法
    public static void main(String[] args) {
        String str = "abcdcba";
        boolean isPalindrome = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
    }
}
