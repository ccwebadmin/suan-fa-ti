package com.easy.thread.blockways;

/**
 * @author cc
 * @date 2023/6/15-23:06
 */
public class SleepWay {
    public static void main(String[] args) {
        System.out.println("开始执行...");
        try {
            Thread.sleep(5000); // 线程休眠5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5秒钟已过");
    }
}
