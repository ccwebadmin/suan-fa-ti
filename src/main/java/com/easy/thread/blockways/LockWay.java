package com.easy.thread.blockways;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cc
 * @date 2023/6/15-23:53
 */
public class LockWay {
    //使用锁对象阻塞线程
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        // 线程1
        new Thread(() -> {
            try {
                lock.lock(); // 获取锁
                System.out.println("线程1获取了锁");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // 释放锁
                System.out.println("线程1释放了锁");
            }
        }).start();
        // 线程2
        new Thread(() -> {
            try {
                lock.lock(); // 获取锁
                System.out.println("线程2获取了锁");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock(); // 释放锁
                System.out.println("线程2释放了锁");
            }
        }).start();
    }
}
