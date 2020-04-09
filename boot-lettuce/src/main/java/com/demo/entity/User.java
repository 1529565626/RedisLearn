package com.demo.entity;

import lombok.Data;

/**
 * @author Martin_W
 * @date 2020/4/8 0008 18:03
 */
@Data
public class User {
    private  String id;

    private String name;

    private Integer age;
    public static String getUserRedisKey(){
        return "RedisDemo"+"user";
    }
}
