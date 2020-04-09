package com.demo.service.impl;

import com.demo.entity.User;
import com.demo.service.IUserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Martin_W
 * @date 2020/4/9 0009 9:46
 */
@Service
@Log
public class UserServiceImpl implements IUserService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Resource(name="redisTemplate")
    private ValueOperations<String,String> StrTemp;

    @Resource(name="redisTemplate")//k  user hk id hv object
    private HashOperations<String  , String, User> hash;

    /**
     * 通过key获取redis的值
     *
     * @param key
     * @return
     */
    @Override
    public String getString(String key) {
        if (redisTemplate.hasKey(key)){
            log.info("------>>Redis中查询出来的");
//            return (String)redisTemplate.opsForValue().get(key);
            return StrTemp.get(key);
        }else {
            String val = "RedisTemplate模板学习lettuce客户端";
            log.info("------>>MqSQL中查询出的："+val);
//            redisTemplate.opsForValue().set(key,val);
            StrTemp.set(key,val);
            log.info("------>>MqSQL中查询出的结果注入Redis中");
            return val;
        }
    }

    @Override
    public void expireStr(String key,String value){
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expire(key,2, TimeUnit.HOURS);
    }

    /**
     * hash 类型
     * @param id
     * @return
     */
    @Override
    public User selectById(String id) {
        if (redisTemplate.opsForHash().hasKey(User.getUserRedisKey(),id)){
            return hash.get(User.getUserRedisKey(),id);
        }else {
            log.info("---->>查询MySQL数据库");
            User u = new User();
            u.setId(id);
            u.setAge(23);
            u.setName("张三");
            hash.put(User.getUserRedisKey(),id,u);
            return u;
        }
    }
}
