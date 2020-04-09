package com.example.demo.util.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.HashSet;

/**
 * <p>
 * 参数判断 判空处理
 * </p>
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年3月23日 下午9:14:02
 * @see Copyright (c) 2018 泉州卓旻网络科技有限公司
 */
@SuppressWarnings("rawtypes")
public class BenNoEmpty {
    /**
     * 判断Model里制定的某些字段是否为空
     *
     * @param json
     * @param array
     * @return
     */
    public static String NoEmpty(Object json, String[] array) {
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(json));
        for (int i = 0; i < array.length; i++) {
            String cs = array[i];
            if (jsonObject.get(cs) == null || "".equals(jsonObject.get(cs))) {
                return cs + ":Can't be empty";
            }
        }
        return "SUCCESS";
    }

    /**
     * 判断Model里的每个字段是否有为空
     *
     * @param <T>
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> boolean NoEmpty(Object obj, String[] array, boolean flag) throws Exception {
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        int size = 0;
        HashSet<String> hashSet = new HashSet<>();
        if (array != null) {
            for (String key : array) {
                hashSet.add(key);
            }
        }
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            if (!flag) {
                if (f.get(obj) == null) {
                    if (hashSet.contains(f.getName())) {
                        System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(obj));
                        return false;
                    }
                    continue;
                }
                if (hashSet.contains(f.getName())) {
                    System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(obj));
                    continue;
                }
            }
            if (f.get(obj) == null) {
                System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(obj));
                return false;
            }
            System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(obj));
            size = size + 1;
        }
        if (flag) {
            if (size == fields.length) {
                return true;
            }
            return false;
        }
        return true;
    }
}
