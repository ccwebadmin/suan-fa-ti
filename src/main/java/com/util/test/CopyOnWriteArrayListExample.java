package com.util.test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        // 启动多个线程进行读写操作
        Thread writer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add("Item " + i);
            }
        });

        Thread reader1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.forEach(System.out::println);
            }
        });

        Thread reader2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.forEach(System.out::println);
            }
        });

        writer.start();
        reader1.start();
        reader2.start();

        try {
            writer.join();
            reader1.join();
            reader2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final list size: " + list.size());
    }
}
