package com.example.demo.util;

import java.lang.annotation.*;

/**
 * <p>
 * token 验证注解类
 * </p>
 * ***********************************************
 * BECAUSE OF CHOICE, STICK TO IT.               *
 * ***********************************************
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年06月20日 17:25
 * @see Copyright (c) 2018 泉州卓旻网络科技有限公司
 */
@Documented
@Target(ElementType.METHOD) // 这个注解是应用在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessToken {

    /**
     * 当 Token 为 false 不做判断
     *
     * @return true
     */
    boolean Token() default true;
}