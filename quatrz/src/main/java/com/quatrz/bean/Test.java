package com.quatrz.bean;

import com.quatrz.service.OrderScheduler;
import org.quartz.*;

public class Test {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        String orderNoHead = "20200427";
        String msg = "订单过期未付款，进行关闭订单";
        for (int i = 1;i<100;i++){
            System.out.println("第"+i+"次开始");
            String orderNo = "";
            if (i<10){
                orderNo = orderNoHead+"00"+i;
            }else if ( i<100&&i>10){
                orderNo = orderNoHead+"0"+i;
            }else {
                orderNo = orderNoHead+i;
            }
            OrderScheduler.orderClose(""+i,orderNo,msg);
            System.out.println("第"+i+"次结束");
        }


       /* // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(RefundJob.class)
                .withIdentity("job1", "group1").build();
        SimpleTrigger trigger = (SimpleTrigger) newTrigger()
                .withIdentity("trigger1", "group1")
                .startAt(futureDate(1, DateBuilder.IntervalUnit.MINUTE))                     // some Date
                .forJob("job1", "group1")                 // identify job with name, group strings
                .build();

        //4、执行
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("--------scheduler start ! ------------");
        scheduler.start();

        //睡眠
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");*/
    }


}
