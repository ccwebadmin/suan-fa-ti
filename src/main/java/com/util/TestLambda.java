package com.util;

// 自定义函数式接口

import com.util.test.MathOperation;

public  class TestLambda implements MathOperation{

    public static void main(String[] args) {
        int x = 10;
        assert x == 10 : "x should be 10";

        // 这里将抛出 AssertionError 因为 y 不等于 20
        int y = 15;
        assert y == 20 ; // 断言失败，抛出异常
    }
//    public static void main(String[] args) {
//        // 使用 Lambda 表达式实现接口方法
//        MathOperation addition = (a, b) -> a * b;
//        MathOperation addition1 = new TestLambda();
//        System.out.println("10 + 5 = " + addition.operate(10, 5));
//        System.out.println("10 + 5 = " + addition1.operate(10, 5));
//    }

    @Override
    public int operate(int a, int b) {
        return a + b;
    }
}