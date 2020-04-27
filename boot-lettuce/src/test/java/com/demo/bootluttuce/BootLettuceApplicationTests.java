package com.demo.bootluttuce;

import com.demo.entity.Product;
import com.demo.entity.User;
import com.demo.mapper.ProductMapper;
import com.demo.util.TaskManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
class BootLettuceApplicationTests {
    @Autowired
    private TaskManager taskManager;
    @Resource
    private ProductMapper productMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }
    @Test
    @Transactional
    public void test(){
        Product p1 = new Product();
        p1.setProductId("123");
        productMapper.insert(p1);
        r1();
        System.out.println(1);
    }

    private void r1(){
        System.out.println(2);
        Product p1 = new Product();
        p1.setProductId("1231");
        productMapper.insert(p1);
        System.out.println(3);
        throw new RuntimeException("进行回滚");
    }




}
