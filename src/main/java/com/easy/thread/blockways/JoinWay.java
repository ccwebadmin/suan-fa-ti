package com.easy.thread.blockways;

/**
 * @author cc
 * @date 2023/6/15-23:39
 */

public class JoinWay {
    //使用join()函数阻塞主线程，等待子线程执行完毕
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始执行...");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程开始执行...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程执行完毕");
            }
        });
        t.start();

        t.join(); // 等待子线程执行完毕
        System.out.println("主线程执行完毕");
    }
}
