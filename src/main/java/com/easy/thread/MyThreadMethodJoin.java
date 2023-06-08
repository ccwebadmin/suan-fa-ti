package com.easy.thread;

/**
 * @author cc
 * @date 2023/6/8-22:56
 */
public class MyThreadMethodJoin extends Thread {
    public MyThreadMethodJoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread " + getName() + " started.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Thread " + getName() + " interrupted.");
            return;
        }
        System.out.println("Thread " + getName() + " finished.");
    }

    public static void main(String[] args) throws Exception {
        MyThreadMethodJoin t1 = new MyThreadMethodJoin("Thread 1");
        MyThreadMethodJoin t2 = new MyThreadMethodJoin("Thread 2");
        MyThreadMethodJoin t3 = new MyThreadMethodJoin("Thread 3");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        t3.start();
        t3.join();
        System.out.println("Main thread finished.");
    }

}
