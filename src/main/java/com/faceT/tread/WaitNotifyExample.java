package com.faceT.tread;

/**
 * @Description
 * @Author cc
 * @Date 2025年05月19日 17:01
 */
class WaitNotifyExample {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread1 is waiting for lock...");
                    lock.wait();
                    System.out.println("Thread1 is resumed after wait.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread2 has lock and will notify...");
                lock.notify();
                System.out.println("Thread2 has notified.");
            }
        });

        thread1.start();
//        try {
//            Thread.sleep(1000); // 确保 thread1 先获取锁并调用 wait()
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread2.start();
    }
}

