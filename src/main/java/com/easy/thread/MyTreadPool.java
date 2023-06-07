package com.easy.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author cc
 * @date 2023/5/22-20:17
 */
public class MyTreadPool {
    public static void main(String[] args) {
        // 创建线程池，核心线程池大小为5，最大线程池大小为10，线程空闲时间为1000ms
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 创建10个任务
        for (int i = 1; i <= 10; i++) {
            RunnableTask task = new RunnableTask("Task " + i);
            executor.execute(task); // 提交任务给线程池执行
        }

        executor.shutdown(); // 关闭线程池
    }

    public static class RunnableTask implements Runnable {
        private final String message;

        public RunnableTask(String message) {
            this.message = message;
        }

        public void run() {
            // 线程需要执行的操作
            System.out.println("Task " + message + " is running...");
        }
    }

}

