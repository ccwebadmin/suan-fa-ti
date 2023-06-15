package com.easy.thread.blockways;

/**
 * @author cc
 * @date 2023/6/15-23:29
 */
public class WaitWayNoJoin {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "被唤醒，继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程1");
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    Thread.sleep(3000);
                    lock.notify();
                    System.out.println(Thread.currentThread().getName() + "唤醒线程1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "线程2");
        t1.start();
        t2.start();
        System.out.println("主线程结束");
    }
    //这种情况下，线程1还没有执行完毕就被主线程结束了，因此锁没有被释放，线程1就永远无法被唤醒了。这种情况虽然不会抛出异常，但是会导致程序产生死锁，从而无法继续执行。
    // 因此，使用join方法来确保线程执行完毕是一个好习惯。
}
