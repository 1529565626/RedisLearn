package com.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

import java.util.Date;

/**
 * <p>
 * 任务调度示例
 * </p>
 * ***********************************************
 * BECAUSE OF CHOICE, STICK TO IT.               *
 * ***********************************************
 *
 * @author Yang@Jowim.com
 * @version V1.0
 * @date 2018年04月15日 1:02
 */
@Component
public class TaskManager {

    /**
     * 控制台打印输出
     */
    private final static Logger LOG = LoggerFactory.getLogger(TaskManager.class);

    /**
     * 运行调度
     */
    @Scheduled(initialDelay = 1000, fixedRate = 3600000)
//    @Scheduled(fixedRate = 5000)
    public void timedTask() {
        LOG.info("卓旻八叔商城系统运行调度中.....");
    }

    /**
     * fixedDelay属性定义调度间隔时间。调度需要等待上一次调度执行完成。
     */
    //@Scheduled(fixedDelay = 5000)

    /**
     * fixedRate属性定义调度间隔时间。调度不等待上一次调度执行完成。
     */
    //@Scheduled(fixedRate = 5000)

    /**
     * initialDelay属性定义初始化后的启动延迟时间
     */
    //@Scheduled(initialDelay = 1000, fixedRate = 5000)

    /**
     * cron属性支持使用cron表达式定义触发条件
     */
    @Scheduled(cron = "0 30 18 * * ?")
    public void print() throws TestException, InterruptedException {

    }

    public static class TestExceptionHandler implements ErrorHandler {
        @Override
        public void handleError(Throwable t) {
            System.out.println("定时任务发生异常，进行处理");
        }
    }

    private class TestException extends Exception {

    }

    @Async
    public void closeOrder(String order){
        System.out.print("创建订单异步关闭任务");
        System.out.println(new Date());
        try {
            Thread.sleep(1000*3);
            System.out.print("订单过期,开始关闭"+order);
            System.out.println(new Date());
        } catch (InterruptedException e) {
            LOG.error("订单定时关闭任务异常");
            e.printStackTrace();
        }
    }

}
