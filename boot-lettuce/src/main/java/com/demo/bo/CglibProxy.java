package com.demo.bo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    //(10)
    private Enhancer enhancer = new Enhancer();
    //(11)
    public Object getProxy(Class clazz){
        //（12）设置被代理类的Class对象
        enhancer.setSuperclass(clazz);
        // (13)设置拦截器回调
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)throws Throwable
    {
        System.out.println(obj.getClass().getName()+"."+method.getName());
        Object result = proxy.invokeSuper(obj, args);return result;
    }

}
