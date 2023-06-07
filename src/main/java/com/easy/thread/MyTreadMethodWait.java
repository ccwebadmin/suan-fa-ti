package com.easy.thread;

/**
 * @author cc
 * @date 2023/6/7-20:01
 */
public class MyTreadMethodWait {

        private static final int MAX_COUNT = 10; // 缓冲区容量
        private static final Object LOCK = new Object();//用于线程通信的锁对象
        private static int item = 0;

        static class Producer implements Runnable {
            private final String name;

            public Producer(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                while (true) {
                    synchronized (LOCK) {
                        while (item == MAX_COUNT) { // 缓冲区满了，生产者线程等待
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        item++;
                        System.out.println("Producer " + name + " 生产了 1 个产品。");
                        LOCK.notifyAll();
                    }
                }
            }
        }

        static class Consumer implements Runnable {
            private final String name;

            public Consumer(String name) {
                this.name = name;
            }

            @Override
            public void run() {
                while (true) {
                    synchronized (LOCK) {
                        while (item == 0) { // 缓冲区为空，消费者线程等待
                            try {
                                LOCK.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        item--;
                        System.out.println("Consumer " + name + " 消费了 1 个产品。");
                        LOCK.notifyAll();
                    }
                }
            }
        }

        public static void main(String[] args) throws Exception {

            Thread producerThread1 = new Thread(new Producer("A"));
            Thread producerThread2 = new Thread(new Producer("B"));
            Thread consumerThread1 = new Thread(new Consumer("X"));
            Thread consumerThread2 = new Thread(new Consumer("Y"));
            producerThread1.start();
            producerThread2.start();
            consumerThread1.start();
            consumerThread2.start();

            Thread.sleep(300); // 运行 10 秒钟
            producerThread1.interrupt(); // 中断生产者线程1
            producerThread2.interrupt(); // 中断生产者线程2
            consumerThread1.interrupt(); // 中断消费者线程1
            consumerThread2.interrupt(); // 中断消费者线程2
        }

}
