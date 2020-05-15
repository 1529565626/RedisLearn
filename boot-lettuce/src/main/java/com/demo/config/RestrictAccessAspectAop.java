package com.demo.config;

import com.demo.util.ResponseMessage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


@Order(2)
@Aspect
@Component
public class RestrictAccessAspectAop {

    private final static Logger LOG = LoggerFactory.getLogger(RestrictAccessAspectAop.class);


    @Resource(name = "redisTemplate")
    private RedisTemplate<String,Object> redisTemp;


    @Pointcut("execution(* com.demo.web.*.*(..))")
    private void restrictAccessAspect(){

    }

    @Around("restrictAccessAspect()")
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        Method method = getMethod(pjp);
        boolean submit = false;
        if (method != null){
            LOG.info("开始统计规定时间内的访问次数");
            RestrictAccessAspect access = method.getAnnotation(RestrictAccessAspect.class);
            if (access != null) {
                submit = access.Count();
            }
            if (!submit) {
                LOG.debug("表单验证取消...");
                return objectProceedingJoinPoint(pjp);
            }
        }
        if (restrictAccessAspectAop(pjp)){
            return objectProceedingJoinPoint(pjp);
        }else {
            return ResponseMessage.error("请求异常，访问过于频繁，请稍后再做尝试！");
        }
    }

    private boolean restrictAccessAspectAop(ProceedingJoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
        Method method = getMethod(joinPoint);
        RestrictAccessAspect access = method.getAnnotation(RestrictAccessAspect.class);
        String methodName = method.getName();
        long timeout = access.timeout();

        if (!redisTemp.hasKey(methodName+ip)){
            redisTemp.opsForValue().set(methodName+ip,0,timeout,TimeUnit.SECONDS);
        }

        long restrictCount = access.restrictCount();
        Long count = redisTemp.opsForValue().increment(methodName+ip,1);
        if (count > restrictCount){
            return false;
        }
        return  true;
    }


    /**
     * 获取 Method 验证
     *
     * @param pjp 切面
     * @return 方法
     */
    private Method getMethod(ProceedingJoinPoint pjp) {
        Object target = pjp.getTarget();
        String methodName = pjp.getSignature().getName();
        Signature sig = pjp.getSignature();
        MethodSignature msig;
        Method method = null;
        try {
            if (!(sig instanceof MethodSignature)) {
                throw new IllegalArgumentException("该注解只能用于方法");
            }
            msig = (MethodSignature) sig;
            Class[] parameterTypes = msig.getMethod().getParameterTypes();
            method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return method;
    }
    /**
     * 执行切面方法返回值
     *
     * @param pjp 切面
     * @return 方法返回值
     */
    private Object objectProceedingJoinPoint(ProceedingJoinPoint pjp) throws Throwable {
        Object returnValue;
        Object[] args = pjp.getArgs();
        returnValue = pjp.proceed(args);
        return returnValue;
    }
}
