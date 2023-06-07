package com.easy.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author cc
 * @date 2023/5/27-17:37
 */
//处理线程中未捕获的异常
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName());
        e.printStackTrace();
    }
}
