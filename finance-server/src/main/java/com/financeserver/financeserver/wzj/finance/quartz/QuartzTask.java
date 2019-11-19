package com.financeserver.financeserver.wzj.finance.quartz;

import com.financeserver.financeserver.wzj.finance.service.taskService.TaskService;
import com.financeserver.financeserver.wzj.finance.service.taskService.TestTaskService;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class QuartzTask {

    private Logger log = LoggerFactory.getLogger(QuartzTask.class);

    @Autowired
    TaskService taskService;

    @PostConstruct
    public void task()throws SchedulerException {
        log.info("线程开始" + new Date());

        // 从数据库中查出需要批量执行的数据
        taskService.sendTask(TestTaskService.class, "testService", "testGroup", "0/5 * * * * ?");

        log.info("线程结束" + new Date());
    }
}
