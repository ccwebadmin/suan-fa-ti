package com.faceT;

@FunctionalInterface
interface MyFunctionalInterface {
    // 唯一的抽象方法
    void doSomething();

    // 默认方法
    default void defaultMethod() {
        System.out.println("This is a default method.");
    }

    // 静态方法
    static void staticMethod() {
        System.out.println("This is a static method.");
    }
}