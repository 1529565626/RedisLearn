package com.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Martin_W
 * @date 2020/4/8 0008 18:03
 */
@Data
public class User implements Serializable {
    private  String id;

    private String name;

    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static String getUserRedisKey(){
        return "RedisDemo"+"user";
    }
}
