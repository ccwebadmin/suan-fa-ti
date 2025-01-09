package com.labuladong;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author cc
 * @Date 2025年01月08日 16:41
 */
public class DynamicArray<E> {

    //底层存数
    private E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }
    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //末尾添加元素
    public void addLast(E e) {
        //当前数组的大小
        int capacity = data.length;
        // 判断是否需要扩容
        if (size == capacity) {
            resize(2 * capacity);
        }
        // 添加元素
        data[size] =e;
        //当前元素的个数
        size++;
    }

    //在指定位置添加元素
    public void add(int index, E e) {
        checkIndex(index);

        //当前数组的大小
        int capacity = data.length;
        // 判断是否需要扩容
        if (size == capacity) {
            resize(2 * capacity);
        }
        //当前index的位置之后的元素都后移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //在指定的位置删除元素
    public E remove(int index) {
        checkIndex(index);
        int cap = data.length;
        // 可以缩容，节约空间
        if (size == cap / 4) {
            resize(cap / 2);
        }

        E ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        size--;
        return ret;
    }

    //检查 index 索引位置是否可以添加元素
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
    }

    //数组扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        //for循环可以替换：System.arraycopy(data, 0, newData, 0, size);
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    // 工具方法
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }



}
