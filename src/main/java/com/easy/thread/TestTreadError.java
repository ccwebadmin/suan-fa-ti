package com.easy.thread;


/**
 * @author cc
 * @date 2023/5/27-17:11
 */
public class TestTreadError {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Thread.setDefaultUncaughtExceptionHandler(MyUncaughtExceptionHandler.class.newInstance());
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("1");

    }
}
