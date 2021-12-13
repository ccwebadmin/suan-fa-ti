package com.疯狂讲义;

/**
 * @author cc
 * @date 2021/11/21-23:23
 */
public class CharTest {
    public static void main(String[] args) {
        char var1 = '蔡';
        int var2 =var1;
        //输出该unicode码对应的编号  34081
        System.out.println(var2);
        char var3 ='\u9998';
        //输出该编码对应的字符   馘
        System.out.println(var3);
        //该编号对应的字符    ^
        char var4 =94;
        System.out.println(var4);
    }
}
