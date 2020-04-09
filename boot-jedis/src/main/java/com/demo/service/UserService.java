package com.demo.service;

/**
 * @author Martin_W
 * @date 2020/4/8 0008 17:32
 */
public interface UserService {

    /**
     * Redis String 类型
     * 需求： 用户输入一个key
     * 先判断redis中是否存在该数据
     *      如果存在，查询Redis中，并返回
     *      如果不存在，在MySQL中查询，返回
     */
    public String getString(String key);

}
