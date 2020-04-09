package com.example.demo.util;

import java.lang.annotation.*;

/**
 * 方法日志记录
 *
 * @return true
 */
@Documented
@Target(ElementType.METHOD) // 这个注解是应用在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodLog {

    /**
     * 当前数据运行模块
     *
     * @return
     */
    String module() default "";

    /**
     * 当前用户操作功能
     *
     * @return
     */
    String methods() default "";
    /**
     * 当 MethodLogLimit 为true时做判断验证
     * @return
     */
    boolean MethodLogLimit() default false;
}
