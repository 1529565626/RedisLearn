package com.demo.service;

import com.demo.entity.User;

/**
 * @author Martin_W
 * @date 2020/4/9 0009 9:45
 */
public interface IUserService {

    /**
     * 通过key获取redis的值
     * @param key
     * @return
     */
    String getString(String key);

   void expireStr(String key, String value);

   User selectById(String id);

}
