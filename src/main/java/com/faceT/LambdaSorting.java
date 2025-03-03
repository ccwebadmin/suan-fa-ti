package com.faceT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Fruit {
    String name;
    int weight;

    public Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + ": " + weight + "克";
    }
}

// 创建一个专门的“裁判团队”类
class FruitWeightComparator implements Comparator<Fruit> {
    @Override
    //当结果为负数时，f1 会被排在 f2 前面 当结果为正数时，f2 会被排在 f1 前面
    public int compare(Fruit f1, Fruit f2) {
        return f1.weight - f2.weight;
    }
}

public class LambdaSorting {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("苹果", 200));
        fruits.add(new Fruit("香蕉", 150));
        fruits.add(new Fruit("西瓜", 5000));

        //方式1 创建专门的比较器
        Collections.sort(fruits, new FruitWeightComparator());
        //方式2 匿名内部类
        Collections.sort(fruits, new Comparator<Fruit>() {
            @Override
            public int compare(Fruit f1, Fruit f2) {
                return f1.weight - f2.weight;
            }
        });
        //方式3直接使用 Lambda 表达式指定排序规则
       Collections.sort(fruits, (f1, f2) -> f1.weight - f2.weight);

        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }
}