package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * @author sasaki
 * @date 2020/5/4 0004 9:55
 */
@Service
public interface QuartzService {

    /**
     * 新增一个定时任务
     * @param jName 任务名称
     * @param jGroup 任务组
     * @param tName 触发器名称
     * @param tGroup 触发器组
     * @param cron cron表达式
     */
    void addJob(String jName, String jGroup, String tName, String tGroup, String cron);

    /**
     * 暂停定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    void pauseJob(String jName, String jGroup);

    /**
     * 继续定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    void resumeJob(String jName, String jGroup);

    /**
     * 删除定时任务
     * @param jName 任务名
     * @param jGroup 任务组
     */
    void deleteJob(String jName, String jGroup);


    void orderClose(String groupid, String orderNo, String Msg, int closeTime);

}
