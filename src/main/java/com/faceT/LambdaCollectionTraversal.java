package com.faceT;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author cc
 * @Date 2025年01月24日 17:00
 */
public class LambdaCollectionTraversal {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("苹果");
        fruits.add("香蕉");
        fruits.add("橙子");

        //forEach的入参也是函数式接口，所以可以用Lambda表达式
        fruits.forEach(fruit -> System.out.println(fruit));
    }
}
