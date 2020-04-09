package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * <p>
 * 返回辅助
 * </p>
 * ***********************************************
 * BECAUSE OF CHOICE, STICK TO IT.               *
 * ***********************************************
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年09月06日 17:35
 * @see Copyright (c) 2018 泉州卓旻网络科技有限公司
 */
@Component
public class ResponseMessage<T> implements Serializable {

    private static final long serialVersionUID = 8992436576262574064L;
    //状态码
    protected int status;
    //响应数据
    public T result;
    //调用结果消息
    protected String message = "";
    //响应时间戳
    private Long timestamp = System.currentTimeMillis();

    /**
     * 成功不弹窗并且无响应数据 status：0
     *
     * @param
     * @return
     */
    public static <T> ResponseMessage<T> ok() {
        return ok(0, "success");
    }

    /**
     * 成功不弹窗并且有响应数据 status：0
     *
     * @param result
     * @return
     */
    public static <T> ResponseMessage<T> ok(T result) {
        return ok(0, null, result);
    }

    /**
     * 自定义返回参数
     *
     * @param status
     * @param message
     * @param result
     * @return
     */
    public static <T> ResponseMessage<T> ok(int status, String message, T... result) {
        ResponseMessage<T> msg = new ResponseMessage<>();
        msg.status = status != 1 ? status : 0;
        if (message != null && !"".equals(message))
            msg.message = message;
        else
            msg.message = "success";
        msg.result = result != null && result.length != 0 ? result[0] : null;
        return msg;
    }

    /**
     * 失败（弹窗）
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseMessage<T> error() {
        return error(1, "failed");
    }

    /**
     * 失败（弹窗）
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseMessage<T> error(String message) {
        return error(1, message);
    }

    /**
     * 失败自定义参数
     *
     * @param status
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ResponseMessage<T> error(int status, String message, T... result) {
        ResponseMessage<T> msg = new ResponseMessage<>();
        msg.status = status != 0 ? status : 1;
        if (message != null && !"".equals(message))
            msg.message = message;
        else
            msg.message = "failed";
        msg.result = result != null && result.length != 0 ? result[0] : null;
        return msg;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }


    public T getResult() {
        return result;
    }


    public Long getTimestamp() {
        return timestamp;
    }

    public ResponseMessage<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseMessage<T> setResult(T result) {
        this.result = result;
        return this;
    }

    public ResponseMessage<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
