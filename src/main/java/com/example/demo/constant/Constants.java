package com.example.demo.constant;

/**
 * <p>
 * 公共常量
 * </p>
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年1月16日 上午11:18:17
 * @see Copyright (c) 2018 泉州卓旻网络科技有限公司
 */
public class Constants {

    /**
     * 执行成功（不需要弹窗） 0
     */
    public static final int SUCCESS = 0;

    /**
     * 执行成功（需要弹窗） 2
     */
    public static final int SUCCESS_ACTION = 2;

    /**
     * 执行失败 1
     */
    public static final int FAILED = 1;

    /**
     * 参数不全/参数为空 3
     */
    public static final int ERROR_NULL = 3;

    /**
     * 身份令牌校验不通过 12
     */
    public static final int ERROR_TOKEN_VERIFY_NOT_PASS = 12;

    /**
     * 服务器异常 500
     */
    public static final int ERROR_EXCEPTION = 500;

    /**
     * 异常 不支持当前内容类型 415
     */
    public static final int ERROR_EXCEPTION_NOT_TYPE = 415;

    /**
     * 异常 不支持请求方法 405
     */
    public static final int ERROR_EXCEPTION_NOT_REQUEST = 405;

    /**
     * 异常回调 无法读取json 400
     */
    public static final int ERROR_EXCEPTION_NOT_JSON = 400;

    /**
     * 项目标识
     */
    public static final String TOKEN = "/Shopping";
}
