package com.redis;

import com.redis.dto.ResuApiDTO;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author cc
 * @date 2023/9/18-10:10
 */
public class RedisTest {

    @Resource(name = "hsafRedisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * rightPush方法是RedisList接口中的一个方法，用于将一个或多个元素推入Redis列表的右侧（尾部）
     * 有返回值：Long类型的返回值表示操作完成后列表的长度
     * 如果键名不存在，则会创建一个新的列表，并将元素添加到其中
     * 如果键名对应的数据类型不是列表，将无法执行推入操作
     *
     */

    private void demo1() {
        // 假设已经获取到RedisTemplate实例
        ListOperations<String, Object> listOps = redisTemplate.opsForList();

// 将元素推入名为"mylist"的列表的右侧
        long length = listOps.rightPush("mylist", "element1");
        System.out.println("列表长度：" + length);  // 输出：列表长度：1

// 再次将一个元素推入列表的右侧
        length = listOps.rightPush("mylist", "element2");
        System.out.println("列表长度：" + length);  // 输出：列表长度：2

    }

    private void medthod1() {

        ResuApiDTO resuApiDTO = new ResuApiDTO();
        resuApiDTO.setApiId("xx");

        redisTemplate.opsForList().rightPush("key", resuApiDTO);

    }
}
