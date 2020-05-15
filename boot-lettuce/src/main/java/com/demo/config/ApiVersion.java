package com.demo.config;


import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @author Martin_W
 * 接口版本标识注解
 * @date 2020/4/3 0003 10:35
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    /**
     * 版本接口号(对应swagger中的group)
     * @return String[]
     */
    String[] group();
}
