package com.example.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * <p>
 * 全局异常捕获
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
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HashMap<String, Object> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        LOG.error("全局异常提取", e);
        HashMap<String, Object> resut = new HashMap<>();
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            resut.put("code", 404);
            resut.put("info", e.getMessage());
        } else {
            resut.put("code", 500);
            resut.put("info", e.getMessage());
        }
        return resut;
    }
}
