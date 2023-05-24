package com.easy.thread;

/**
 * @author cc
 * @date 2023/5/22-19:21
 */
public class MyThread extends Thread {
    public void run() {
        // 线程需要执行的操作
        System.out.println("MyThread run");
        System.out.println(1/0);
    }

    public static void main(String[] args) {
        MyThread myThread =new MyThread();
        try {
            myThread.start();
        } catch (Exception e) {
            //run 方法没有抛出异常 这里不到异常
            System.out.println(1);
        }
    }
}
