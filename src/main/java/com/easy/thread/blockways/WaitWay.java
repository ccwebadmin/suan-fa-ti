package com.easy.thread.blockways;

/**
 * @author cc
 * @date 2023/6/15-23:07
 */
public class WaitWay {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        // 定义一个线程，用于等待锁的释放
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("等待锁的释放");
                    lock.wait(); // 等待锁的释放
                    System.out.println("锁已经被释放了，线程继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 定义一个线程，用于释放锁
        Thread notifyingThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("释放锁");
                lock.notify(); // 释放锁
            }
        });
        waitingThread.start(); // 启动等待线程
        Thread.sleep(2000); // 休眠2秒让等待线程先执行
        notifyingThread.start(); // 启动释放锁的线程
        waitingThread.join(); // 等待等待线程执行完毕
        notifyingThread.join(); // 等待释放锁的线程执行完毕
    }
}
