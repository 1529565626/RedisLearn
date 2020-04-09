package com.demo;

import com.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class BootJedisApplicationTests {

    @Autowired
    private UserService userService;



    @Test
    void contextLoads() {
        String user = userService.getString("name");
        System.out.println(user);
    }

}
