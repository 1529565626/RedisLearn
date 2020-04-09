package com.example.demo.util.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>
 * 序列化通用类
 * </p>
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年1月20日 下午2:26:04
 * @see Copyright (c) 2018 泉州卓旻网络科技有限公司
 */
public class SerializerUtil {

    /**
     * 序列化
     *
     * @param object
     * @return
     */
    public static byte[] serializeObj(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            throw new RuntimeException("序列化失败!", e);
        }
    }

    /**
     * 序列化
     *
     * @param object
     * @return
     */
    public static LinkedHashMap<byte[], byte[]> serializeObj(Map map) {
        LinkedHashMap<byte[], byte[]> reMap = new LinkedHashMap<>();
        for (Object key : map.keySet()) {
            byte[] newKey = serializeObj(key);
            byte[] newValue = serializeObj(map.get(key));
            reMap.put(newKey, newValue);
        }
        return reMap;
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @return
     */
    public static Object deserializeObj(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("反序列化失败!", e);
        }
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @return
     */
    public static Map deserializeObj(Map<byte[], byte[]> map) {
        if (map == null) {
            return null;
        }
        Map<Object, Object> reMap = new HashMap<>();
        for (byte[] key : map.keySet()) {
            Object newKey = deserializeObj(key);
            byte[] value = map.get(key);
            Object newValue = deserializeObj(value);
            reMap.put(newKey, newValue);
        }
        return reMap;
    }
}