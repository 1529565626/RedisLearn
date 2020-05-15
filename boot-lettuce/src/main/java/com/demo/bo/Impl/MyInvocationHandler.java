package com.demo.bo.Impl;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target)
    {
        super();
        this.target = target;

    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
        //(1)
        System.out.println("-----------------begin "+method.getName()+"-----------------");
        // (2)
        Object result = method.invoke(target, args);
        // (3)
        System.out.println("-----------------end "+method.getName()+"-----------------");
        return result;
    }
    public Object getProxy(){
        // (4)
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }
}
