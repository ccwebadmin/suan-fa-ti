package com.util;

/**
 * @author cc
 * @date 2023/6/30-19:50
 */
public class GarbageCollectionExample {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new ExampleObject();
        }

        // 为了演示目的，等待一段时间，给垃圾回收器充足的时间进行回收
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ExampleObject {
    // 在对象被回收时打印一条消息
    @Override
    protected void finalize() throws Throwable {
        System.out.println("ExampleObject finalized");
        super.finalize();
    }
}
