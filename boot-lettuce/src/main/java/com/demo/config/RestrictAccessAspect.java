package com.demo.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 这个注解是应用在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface RestrictAccessAspect {

    /**
     * 当 Count 为 false 不做判断
     *
     * @return true
     */
    boolean Count() default false;

    /**
     * 指定时间，单位为秒
     * <p>
     * 指redis中秒数
     *
     * @return long
     */
    long timeout() default 10;

    /**
     * 指定时间内的操作次数
     *
     * @return long
     */
    long restrictCount() default 10;
}
