package com.easy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author cc
 * @date 2023/7/20-15:56
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceCaller {
    public static void main(String[] args) {
        // 创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // 提交Runnable任务给线程池执行，无需获取任务结果
        executor.submit(new ServiceTask());

        // 执行主线程中的其他任务
        System.out.println("Main thread: Doing some other work");

        // 关闭线程池
        executor.shutdown();

        System.out.println("Main thread: Done");
    }
}

class ServiceTask implements Runnable {
    @Override
    public void run() {
        // 模拟调用某个耗时的服务
        System.out.println("ServiceTask: Calling a service...");
        try {
            Thread.sleep(3000); // 模拟耗时3秒的服务调用
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ServiceTask: Service call completed");
    }
}
