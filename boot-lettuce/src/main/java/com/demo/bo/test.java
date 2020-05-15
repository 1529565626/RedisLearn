package com.demo.bo;

import com.demo.bo.Impl.MyInvocationHandler;
import com.demo.bo.Impl.UserServiceImpl;
import org.springframework.cglib.core.DebuggingClassWriter;

public class test {

    public static void main(String[] args) {
//        //(5)打开这个开关，可以把生成的代理类保存到磁盘
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",true);
//        //(6)创建目标对象（被代理对象）
//        UserServiceBo service = new UserServiceImpl();
//        //(7)创建一个InvocationHandler实例，并传递被代理对象
//        MyInvocationHandler handler = new MyInvocationHandler(service);
//        //(8)生成代理类
//        UserServiceBo proxy = (UserServiceBo) handler.getProxy(); proxy.add();
        //（14）生成代理类到本地
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:/Users/ssk/Downloads");
        //(15)生成目标对象
        UserServiceImpl service = new UserServiceImpl();
        // （16）创建CglibProxy对象
        CglibProxy cp = new CglibProxy();
        // (17)生成代理类
        UserServiceBo proxy = (UserServiceBo) cp.getProxy(service.getClass());
        proxy.add();
    }

    public void testCglibProxy(){
        //（14）生成代理类到本地
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/ssk/Downloads");
        //(15)生成目标对象
        UserServiceImpl service = new UserServiceImpl();
        // （16）创建CglibProxy对象
        CglibProxy cp = new CglibProxy();
        // (17)生成代理类
        UserServiceBo proxy = (UserServiceBo) cp.getProxy(service.getClass());
        proxy.add();
    }
}
