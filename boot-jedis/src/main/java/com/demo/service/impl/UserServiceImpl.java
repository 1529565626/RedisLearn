package com.demo.service.impl;

import com.demo.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Martin_W
 * @date 2020/4/8 0008 17:35
 */
@Service
@Log
public class UserServiceImpl implements UserService {
    @Autowired
    private JedisPool jedisPool;

    /**
     * Redis String 类型
     * 需求： 用户输入一个key
     * 先判断redis中是否存在该数据
     * 如果存在，查询Redis中，并返回
     * 如果不存在，在MySQL中查询，返回
     *
     * @param key
     */
    @Override
    public String getString(String key) {
        //1、得到redis对象
        Jedis jedis = new Jedis();
        //2、判断key是否存在redis
        String result = null;
        if (jedis.exists(key)){
            log.info("查询redis中的数据");
            result = jedis.get(key);
        }else {
            result = "no pain no gain!";
            log.info("查询mysql数据"+result);
            jedis.set(key,result);
        }
        //3、关闭
        jedis.close();
        return result;
    }
}
