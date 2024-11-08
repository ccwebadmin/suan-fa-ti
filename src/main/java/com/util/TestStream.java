package com.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        boolean anyLongName = names.stream().anyMatch(name -> name.length() > 6);//true
        boolean allLongNames = names.stream().allMatch(name -> name.length() > 3);//false
        boolean noneLongName = names.stream().noneMatch(name -> name.length() > 10);//true
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//        numbers.stream()
//                .forEach(num -> System.out.println(num));

        //        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
//
//        List<String> nameList = names.stream()
//                .collect(Collectors.toList());
//        System.out.println("nameList: " + nameList);


//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        // 使用 Stream 进行过滤操作，只保留偶数
//        List<Integer> evenNumbers = numbers.stream()
//                .filter(num -> num % 2 == 0)
//                .collect(Collectors.toList());
//        System.out.println("Even numbers: " + evenNumbers);
//        System.out.println("old numbers: " + numbers);

//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
//
//// 使用 Stream 进行映射操作，将名字转换为大写
//        List<String> upperCaseNames = names.stream()
//                .map(e->e.toUpperCase())
//                .collect(Collectors.toList());
//
//        System.out.println("Upper case names: " + upperCaseNames);
//
//        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3, 7);
//
//// 使用 Stream 进行排序操作，升序排列
//        List<Integer> sortedNumbers = numbers.stream()
//                .sorted()
//                .collect(Collectors.toList());
//
//        System.out.println("Sorted numbers: " + sortedNumbers);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//// 使用 Stream 进行归约操作，计算所有数的和
//        int sum = numbers.stream()
//                .reduce(0,(a,b)->a+b);//BinaryOperator#apply接收两个参数的函数式接口
////                .reduce(0, Integer::sum);//等价上面的写法
//
//        System.out.println("Sum of numbers: " + sum);
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//// 找出最大值
//        int max = numbers.stream()
////                .reduce(Integer.MIN_VALUE, Integer::max);
//        //等价写法
//                .reduce(Integer.MIN_VALUE, (a,b)->Math.max(a,b));
//        System.out.println("Max value: " + max);
    }
}
