package com.faceT;

/**
 * @Description
 * @Author cc
 * @Date 2025年04月30日 13:49
 */
import java.util.ArrayList;
import java.util.List;

//泛型上界限定符
public class UpperBoundErrorExample {
    // 写法1 ?表示泛型，表示任意类型，方法中不能直接使用，只能用Object
    public static void printNumbers1(List<? extends Number> list) {
        for (Object num : list) {
            System.out.println(num);
        }
    }
    //写法2 T 必须是 Number 的子类,T全局定义可，以在整个方法使用
    public static <T extends Number> void printNumbers2(List<T> list) {
        for (T num : list) {
            System.out.println(num);
        }
    }
    //注意事项：读取安全，不能添加元素，因为不知道添加的是什么类型
    public void process(List<? extends Number> list) {
        Number num = list.get(0); // 读取时是安全的，返回类型是 Number 或其子类
//         list.add(1); // 编译错误，不能往其中添加元素
    }
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);

        // 正确的调用：Integer 和 Double 都是 Number 的子类
        printNumbers1(integerList);
        printNumbers1(doubleList);

        // 编译错误：String 不是 Number 的子类
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        // printNumbers(stringList); // 编译错误
    }
}

