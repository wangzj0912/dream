package com.financeserver.wzj.finance.service.taskService;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.logging.Logger;

public class TestTaskService implements Job {

    private Logger log = Logger.getLogger("TestTaskService.class");

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("test start =============== " + new Date());

    }
}
