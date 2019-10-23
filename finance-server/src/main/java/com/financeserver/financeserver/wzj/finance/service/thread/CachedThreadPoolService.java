package com.financeserver.financeserver.wzj.finance.service.thread;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CachedThreadPoolService implements Runnable {

    private Logger log = Logger.getLogger("CachedThreadPoolService.calss");

    CachedThreadPoolService() {

    }

    @Override
    public void run() {
        log.info("CachedThreadPoolService 线程开始");

        try {
//            Thread.sleep(10000);
        } catch (Exception e) {
            log.info("CachedThreadPoolService 异常");
        }

        log.info("CachedThreadPoolService 线程结束");
    }
}
