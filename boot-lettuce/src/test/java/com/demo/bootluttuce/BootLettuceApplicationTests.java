package com.demo.bootluttuce;

import com.demo.entity.User;
import com.demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootLettuceApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {

        User result = userService.selectById("新同学");
        System.out.println(result.toString());
    }

}
