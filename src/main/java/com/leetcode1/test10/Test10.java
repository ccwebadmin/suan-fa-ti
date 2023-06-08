package com.leetcode1.test10;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author cc
 * @date 2023/4/6-11:31
 */
public class Test10 {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("HH");
        String hour = df.format(new Date());
        System.out.println(hour);


        String s1 = "ab",  p1 = ".*";
        String s2 = "aa", p2 = "a*";
        String s3 = "aa", p3 = "a";

        System.out.println(isMatch(s1,p1));
        System.out.println(isMatch(s2,p2));
        System.out.println(isMatch(s3,p3));
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
