package com.quatrz.bean;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sasaki
 * @date 2020/4/27 0027 10:50
 */
public class RefundJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        System.out.println(printTime+":订单"+jobExecutionContext.getJobDetail().getJobDataMap().get("orderNo")+jobExecutionContext.getJobDetail().getJobDataMap().get("msg"));
    }
}
