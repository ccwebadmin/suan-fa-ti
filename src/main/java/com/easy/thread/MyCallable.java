package com.easy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author cc
 * @date 2023/5/22-19:32
 */
//泛型表示返回值的类型
// call()方法1.有返回值 2.可以抛出异常
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("MyCallable run");
        System.out.println(1/0);
        return 1;
    }

    public static void main(String[] args) {
        MyCallable myCallable =new MyCallable();
        FutureTask<Integer> task = new FutureTask<>(myCallable);

        Thread thread = new Thread(task);
        thread.start();

        try {
            System.out.println(task.get());
            // 处理返回结果
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
        }
    }
}
