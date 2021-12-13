package com.疯狂讲义;

/**
 * 二进制  负数补码还原
 * @author cc
 * @date 2021/11/21-17:17
 */
public class Buma {
    public static void main(String[] args) {
        //结果-127
        byte var1 = (byte) 0B10000001;
        System.out.println(var1);

        //结果-128
        byte var2 = (byte) 0B10000000;
        System.out.println(var2);

        System.out.println(0b1001_1000);
    }
}
