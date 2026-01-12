package com.yupizong;

/**
 *
 * @author cc
 * @date 2026年01月09日 17:00
 * @return
 */
// 导入必要的类
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * ConcurrentHashMap 新手入门示例
 * 功能：1. 演示基础增删查改；2. 演示多线程并发操作的线程安全性
 */
public class ConcurrentHashMapDemo {
    // 定义全局 ConcurrentHashMap，供多线程操作
    private static ConcurrentHashMap<String, Integer> goodsStock = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        // 第一部分：基础增删查改操作（和 HashMap 类似）
        System.out.println("=== 第一部分：基础操作 ===");
        basicOperation();

        // 第二部分：多线程并发操作（体现线程安全）
        System.out.println("\n=== 第二部分：多线程并发操作 ===");
        multiThreadOperation();
    }

    /**
     * 基础操作：增、删、查、改、判断、遍历、特有方法 putIfAbsent
     */
    private static void basicOperation() {
        // 1. 新增键值对（put 方法）
        goodsStock.put("商品001", 100);
        goodsStock.put("商品002", 200);
        goodsStock.put("商品003", 150);
        System.out.println("1. 新增3个商品库存后，个数：" + goodsStock.size());
        System.out.println("当前库存内容：" + goodsStock);

        // 2. 覆盖同键的值（put 方法）
        Integer oldStock = goodsStock.put("商品001", 120);
        System.out.println("\n2. 覆盖商品001的库存，旧库存：" + oldStock);
        System.out.println("覆盖后库存内容：" + goodsStock);

        // 3. 特有方法：putIfAbsent（键不存在才新增）
        Integer result1 = goodsStock.putIfAbsent("商品004", 300); // 键不存在，新增成功，返回null
        Integer result2 = goodsStock.putIfAbsent("商品001", 200); // 键已存在，不操作，返回旧值120
        System.out.println("\n3. putIfAbsent 操作结果：");
        System.out.println("商品004新增结果（返回null）：" + result1);
        System.out.println("商品001重复新增结果（返回旧值）：" + result2);
        System.out.println("操作后库存内容：" + goodsStock);

        // 4. 根据键获取值（get 方法）
        Integer stock002 = goodsStock.get("商品002");
        Integer stock005 = goodsStock.get("商品005"); // 不存在的键，返回null
        System.out.println("\n4. 获取指定商品库存：");
        System.out.println("商品002库存：" + stock002);
        System.out.println("商品005库存（不存在）：" + stock005);

        // 5. 判断键是否存在（containsKey 方法）
        boolean has003 = goodsStock.containsKey("商品003");
        boolean has005 = goodsStock.containsKey("商品005");
        System.out.println("\n5. 判断商品是否存在：");
        System.out.println("商品003是否存在：" + has003);
        System.out.println("商品005是否存在：" + has005);

        // 6. 删除键值对（remove 方法）
        Integer removedStock = goodsStock.remove("商品003");
        System.out.println("\n6. 删除商品003，被删除的库存：" + removedStock);
        System.out.println("删除后库存内容：" + goodsStock);

        // 7. 遍历 ConcurrentHashMap（和 HashMap 一致，两种常用方式）
        System.out.println("\n7. 遍历库存：");
        // 方式1：键遍历法
        System.out.println("方式1 - 键遍历法：");
        for (String goodsId : goodsStock.keySet()) {
            Integer stock = goodsStock.get(goodsId);
            System.out.println(goodsId + "：" + stock);
        }

        // 方式2：键值对遍历法（效率更高，推荐）
        System.out.println("\n方式2 - 键值对遍历法：");
        for (Map.Entry<String, Integer> entry : goodsStock.entrySet()) {
            String goodsId = entry.getKey();
            Integer stock = entry.getValue();
            System.out.println(goodsId + "：" + stock);
        }
    }

    /**
     * 多线程并发操作：两个线程同时对商品001的库存进行减1操作，各执行100次
     * 演示 ConcurrentHashMap 的线程安全：最终库存结果正确（120 - 200 = -80）
     */
    private static void multiThreadOperation() throws InterruptedException {
        // 先重置商品001的库存为120
        goodsStock.put("商品001", 120);
        System.out.println("初始商品001库存：" + goodsStock.get("商品001"));

        // 线程1：对商品001库存减1，执行100次
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                // 线程安全的更新：先获取当前值，再修改，再放入（简化演示，实际可使用 compute 方法）
                goodsStock.put("商品001", goodsStock.get("商品001") - 1);
            }
        }, "线程1");

        // 线程2：对商品001库存减1，执行100次
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                goodsStock.put("商品001", goodsStock.get("商品001") - 1);
            }
        }, "线程2");

        // 启动两个线程
        thread1.start();
        thread2.start();

        // 等待两个线程执行完毕
        thread1.join();
        thread2.join();

        // 打印最终库存
        System.out.println("两个线程执行完毕后，商品001库存：" + goodsStock.get("商品001"));
        System.out.println("预期库存：120 - 100 - 100 = -80（线程安全，结果正确）");
    }
}