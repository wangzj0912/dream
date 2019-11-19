package com.financeserver.financeserver.wzj.finance.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    private Logger log = LoggerFactory.getLogger(QuartzConfig.class);

    @Bean
    public Scheduler scheduled()throws SchedulerException {
        log.info("bulid Scheduler start");
        // 创建一个Scheduler
        // 获取调度器
        SchedulerFactory schedFact = new StdSchedulerFactory();
        Scheduler sched = schedFact.getScheduler();
        log.info("bulid Scheduler end");
        return sched;
    }
}
