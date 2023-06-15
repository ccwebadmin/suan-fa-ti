package com.easy.thread.blockways;

import java.util.concurrent.SynchronousQueue;

/**
 * @author cc
 * @date 2023/6/15-23:58
 */

public class SynchronousQueueWay {
    //使用同步队列阻塞线程
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        // 线程1
        new Thread(() -> {
            try {
                String data = queue.take(); // 从队列中取出数据，没有数据则阻塞
                System.out.println("线程1获取数据：" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 线程2
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                queue.put("Hello"); // 往队列中添加数据，没有消费者则阻塞
                System.out.println("线程2添加数据：Hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
