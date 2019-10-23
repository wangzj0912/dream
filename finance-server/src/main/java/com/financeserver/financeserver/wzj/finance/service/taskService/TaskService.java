package com.financeserver.financeserver.wzj.finance.service.taskService;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.quartz.Scheduler;


@Service
public class TaskService {

    // 任务调度
    @Autowired
    private Scheduler scheduler;

    public void sendTask(Class jobClass, String name, String group, String cron) throws SchedulerException {

        // 开启调度器
        scheduler.start();
        // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体Job实例
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(name, group).build();

        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(name, group)
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);

    }
}
