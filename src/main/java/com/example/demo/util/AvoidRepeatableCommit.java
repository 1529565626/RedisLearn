package com.example.demo.util;

import java.lang.annotation.*;

/**
 * 防止表单重复提交
 *
 * @author zhang@Jwoim.com
 * @version 1.2
 * @date 2019-7-4
 */
@Documented
@Target(ElementType.METHOD) // 这个注解是应用在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface AvoidRepeatableCommit {

    /**
     * 防止表单重复提交
     *
     * @return true
     */
    boolean CommitLimit() default false;

    /**
     * 指定时间内不能重复提交，单位为秒
     * <p>
     * 指redis中秒数
     *
     * @return long
     */
    long timeout() default 1;
}
