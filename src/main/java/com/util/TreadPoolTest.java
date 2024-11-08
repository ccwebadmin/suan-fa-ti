package com.util;

import java.util.concurrent.*;

public class TreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
//
//        Future<Integer> futureResult = fixedThreadPool.submit(() -> {
//            System.out.println(1/0);
//            System.out.println("Task running in thread: " + Thread.currentThread().getName());
//            return 42;
//        });
//
//        try {
//            Integer result = futureResult.get();//只有调用get方法才能获取调用结果和捕获异常
//            System.out.println("Task result: " + result);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }finally {
//            fixedThreadPool.shutdown();
//        }
        ThreadPoolExecutor customThreadPool = new ThreadPoolExecutor(
                2, // corePoolSize
                5, // maximumPoolSize
                60, TimeUnit.SECONDS, // keepAliveTime
                new ArrayBlockingQueue<>(100), // workQueue
                Executors.defaultThreadFactory(), // threadFactory
                new ThreadPoolExecutor.AbortPolicy() // handler
        );
//        ThreadPoolExecutor customThreadPool = new ThreadPoolExecutor(
//                2, // 核心线程数
//                5, // 最大线程数
//                60, TimeUnit.SECONDS, // 线程空闲时间
//                new ArrayBlockingQueue<>(100) // 等待队列
//        );

        for (int i = 0; i < 100; i++) {
             customThreadPool.submit(() -> {
                System.out.println("Thread running: " + Thread.currentThread().getName());
                return 1;
            });
        }

        customThreadPool.shutdown();
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
//
//        for (int i = 0; i < 100; i++) {
//            fixedThreadPool.execute(() -> {
//                System.out.println("Thread running: " + Thread.currentThread().getName());
//            });
//        }
//
//        fixedThreadPool.shutdown();
    }
}
