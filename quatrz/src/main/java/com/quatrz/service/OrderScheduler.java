package com.quatrz.service;

import com.quatrz.bean.RefundJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

import static org.quartz.DateBuilder.futureDate;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author sasaki
 * @date 2020/4/27 0027 16:47
 */
public class OrderScheduler {

    public static void orderClose(String groupid,String orderNo,String Msg) throws SchedulerException, InterruptedException {
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(RefundJob.class)
                .usingJobData("orderNo",orderNo)
                .usingJobData("msg",Msg)
                .withIdentity("job1", "jobgroup"+groupid).build();
        // 3、构建Trigger实例,
        SimpleTrigger trigger = (SimpleTrigger) newTrigger()
                .withIdentity("trigger1", "jobgroup"+groupid)
                .forJob("job1", "jobgroup"+groupid)
                .startAt(futureDate(1, DateBuilder.IntervalUnit.MINUTE))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()).build();//一直执行
        //4、执行
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("--------scheduler start ! ------------");
        scheduler.start();
    }
}
