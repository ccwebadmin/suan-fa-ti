package com.easy.thread;

/**
 * @author cc
 * @date 2023/5/22-19:24
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable run");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
