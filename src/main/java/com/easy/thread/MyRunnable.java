package com.easy.thread;

/**
 * @author cc
 * @date 2023/5/22-19:24
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Runnable run");
        //测试线程里运行报错是否会影响主线程
        System.out.println(1/0);
    }
}
