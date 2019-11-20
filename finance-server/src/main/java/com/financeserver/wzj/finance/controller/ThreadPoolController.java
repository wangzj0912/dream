package com.financeserver.wzj.finance.controller;

import com.financeserver.wzj.finance.service.thread.CachedThreadPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@RestController
public class ThreadPoolController {

    @Autowired
    private CachedThreadPoolService cachedThreadPoolService;

    private Logger log = Logger.getLogger("ThreadPoolController.class");


    // 缓存线程池  线程无限大，但是如果线程池大于需要处理的线程数，自动回收
    @PostMapping(value = "/cachedThreadPoolTest")
    public void cachedThreadPoolTest(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        log.info("test start");
        for(int i = 0; i < 5; i++){
            executorService.execute(cachedThreadPoolService);
        }
        log.info("test end");
    }


    // 定长线程池 如果超出个数则等待
    @PostMapping(value = "/fixedThreadPoolTest")
    public void fixedThreadPoolTest(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        log.info("test start");
        for(int i = 0; i < 5; i++){
            executorService.execute(cachedThreadPoolService);
        }
        log.info("test end");
    }

    // 定时线程池
    @PostMapping(value = "/scheduledThreadPoolTest")
    public void scheduledThreadPoolTest(){

        log.info("test start");
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.schedule(cachedThreadPoolService, 5, TimeUnit.SECONDS);
        log.info("test end");
    }

}
