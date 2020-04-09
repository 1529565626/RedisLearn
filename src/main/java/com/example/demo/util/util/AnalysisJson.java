package com.example.demo.util.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * <p>
 * 自定义json 解析
 * </p>
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年1月16日 下午3:25:38
 * @see Copyright (c) 2018 泉州卓旻网络科技有限公司
 */
public abstract class AnalysisJson {

    /**
     * 定义于 fastjson
     * <p>
     * {"data":{"":""}}
     *
     * @param data  注入的json String
     * @param clazz 传入对象实体类
     * @param cite  解析值 如"data"
     * @return
     */
    public static <T> T JsonAnalysisObject(String data, String cite, Class<T> clazz) {
        JSONObject json = JSON.parseObject(data);
        String jsonStr = json.getString(cite);
        Object obj = JSONObject.parseObject(jsonStr, clazz);
        return JSONObject.parseObject(jsonStr, clazz);

    }

    /**
     * 定义于 fastjson
     * <p>
     * {"data":[{"":""}]}
     * <p>
     * 适合Array 集合数组类 json
     * <p>
     * 包含多条数据源
     *
     * @param data  注入的json String
     * @param clazz 传入对象实体类
     * @param cite  解析值 如"data"
     * @return Object
     */
    public static Object JsonAnalysisArray(String data, String cite, Class<?> clazz) {
        Object obj = null;
        List<?> list = JsonAnalysisArrayList(data, cite, clazz);
        for (Object ect : list) {
            obj = ect;
        }
        return obj;
    }

    /**
     * 定义于 fastjson
     * <p>
     * {"data":[{"":""},{"":""}...]}
     * <p>
     * 适合Array 集合数组类 json
     * <p>
     * 包含多条数据源
     *
     * @param data  注入的json String
     * @param clazz 传入对象实体类
     * @param cite  解析值 如"data"
     * @return List<?>
     */
    public static <T> List<T> JsonAnalysisArrayList(String data, String cite, Class<T> clazz) {
        JSONObject json = JSON.parseObject(data);
        String jsonStr = json.getString(cite);
        return JSONObject.parseArray(jsonStr, clazz);
    }

    /**
     * 数据格式 返回单数据解析
     *
     * @param data   {"data":{"id":""}}
     * @param cite   "data" 解析引用名称
     * @param second "id" 解析引用名称
     * @return String
     */
    public static String JsonAnalysisString(String data, String cite, String second) {
        JSONObject json = JSON.parseObject(data);
        String jsonStr = json.getString(cite);
        JSONObject jsonString = JSON.parseObject(jsonStr);
        return jsonString.getString(second);
    }

    /**
     * 数据格式 返回单数据解析
     *
     * @param data   {"data":""}
     * @param cite   "data" 解析引用名称
     * @param second "id" 解析引用名称
     * @return String
     */
    public static String JsonAnalysisString(String data, String cite) {
        JSONObject json = JSON.parseObject(data);
        String jsonStr = json.getString(cite);
        return jsonStr;
    }

}
