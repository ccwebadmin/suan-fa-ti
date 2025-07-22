package com.faceT;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author cc
 * @Date 2025年05月08日 15:12
 */

//下界限定符
public class LowerBoundErrorExample {
    // 泛型方法，T 是 Integer 或其父类
    public static void addIntegers1(List<? super Integer> list) {
        list.add(1);
        list.add(2);
    }

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        addIntegers1(numberList); // 正确，Number 是 Integer 的父类

        List<Object> objectList = new ArrayList<>();
        addIntegers1(objectList); // 正确，Object 是 Integer 的父类

        // 编译错误：List<Double> 不符合下界条件
        List<Double> doubleList = new ArrayList<>();
        // addIntegers(doubleList); // 编译错误
    }
}
