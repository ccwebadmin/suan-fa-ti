package com.faceT;

/**
 * @Description
 * @Author cc
 * @Date 2025年01月21日 14:05
 */
public class ValueTrasferTest {
    public static void main(String[] args) {
        int a = 5;
        modifyPrimitive(a);
        System.out.println("After modifyPrimitive: " + a); // 输出: 5

        MyObject obj = new MyObject();
        obj.value = 10;
        modifyObject(obj);
        System.out.println("After modifyObject: " + obj.value); // 输出: 20

        resetReference(obj);
        System.out.println("After resetReference: " + obj.value); // 输出: 20
    }

    public static void modifyPrimitive(int num) {
        num = 10; // 仅仅修改了副本，不影响原始变量
    }

    public static void modifyObject(MyObject obj) {
        obj.value = 20; // 修改了对象的属性，会影响原始对象
    }

    //提示obj是灰的，表示没有使用上
    public static void resetReference(MyObject obj) {
        obj = new MyObject(); // 修改的是引用的副本，不影响原始对象
        obj.value = 30;
        //输出为30
        System.out.println(obj.value);
    }

    static class MyObject {
        int value;
    }
}
