package com.easy.thread.blockways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author cc
 * @date 2023/6/16-0:02
 */
public class ThreadPoolWay {
    public static void main(String[] args) {
        //使用线程池阻塞线程
        ExecutorService pool = Executors.newFixedThreadPool(1);
        // 任务1
        Runnable task1 = () -> {
            System.out.println("任务1开始执行...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务1执行完毕");
        };
        pool.execute(task1);
        // 任务2
        Runnable task2 = () -> {
            System.out.println("任务2开始执行...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务2执行完毕");
        };
        pool.execute(task2);
        // 任务3
        Runnable task3 = () -> {
            System.out.println("任务3开始执行...");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务3执行完毕");
        };
        pool.execute(task3);
        pool.shutdown(); // 关闭线程池
        try {
            pool.awaitTermination(1, TimeUnit.HOURS); // 等待所有线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }
}
