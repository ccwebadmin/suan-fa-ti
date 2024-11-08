package com.util;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {


    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        // 添加元素到队尾
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        //和下面一个实现
        queue.add(40);
        System.out.println(queue);//[10, 20, 30, 40]
        // 获取并移除队首元素
        int element = queue.poll();
        System.out.println("Removed element from queue: " + element);
        System.out.println(queue);//[20, 30, 40]
        // 获取但不移除队首元素
        int peekElement = queue.peek();
        System.out.println("Peeked element from queue: " + peekElement);
        System.out.println(queue);//[20, 30, 40]
        // 检查队列是否为空
        boolean isEmpty = queue.isEmpty();
        System.out.println("Queue is empty: " + isEmpty);
        // 获取队列的大小
        int size = queue.size();
        System.out.println("Queue size: " + size);
    }
}
