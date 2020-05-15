package com.demo.config;

import org.aspectj.apache.bcel.generic.RET;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Order(1)
@Aspect
@Component
public class WebLogAspect {
    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    //切入点描述 这个是controller包的切入点
    @Pointcut("execution(public  * com.demo.web..*.*(..))")
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称


    @Before("controllerLog()")
    public void logBeforeController(JoinPoint joinPoint){
        //这个RequestContextHolder是SpringMVC提供来获得请求的东西
        RequestAttributes requestAttribute = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttribute).getRequest();

        logger.info("URL:"+request.getRequestURI());
        logger.info("HTTP_METHOD:"+request.getMethod());
        logger.info("IP:"+request.getRemoteAddr());
        logger.info("THE ARGS OF THE CONTROLLER:"+ Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature.getDeclaringTypeName()是获取包+类名的 getSignature().getName()获取了方法名
        logger.info("CLASS_METHOD:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //logger.info("TARGET:"+joinPoint.getTarger());//返回的是需要加强的目标类的对象
        //logger.info("THIS:"+joinPoint.getThis());//返回的是经过加强后的代理类对象
    }

    @AfterReturning(returning = "ret",pointcut = "controllerLog()")
    public void doAfterReturning(Object ret)throws RuntimeException{
        if (null != ret){
            String response = ret.toString();
            logger.info("RESPONSE:"+ response);
        }
    }

}
