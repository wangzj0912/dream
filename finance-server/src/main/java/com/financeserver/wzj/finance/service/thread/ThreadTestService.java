package com.financeserver.wzj.finance.service.thread;

import com.financeserver.wzj.finance.model.ThreadModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Future;

/**
 * @Author wangzhaojian
 * @Date 2019/11/8 16:34
 */
@Service
public class ThreadTestService{
    private Logger logger = LoggerFactory.getLogger(ThreadTestService.class);
    @Async
    public Future<ThreadModel> task(int number) {
        ThreadModel model = new ThreadModel();
        try {
            logger.info("threadTest start " + new Date());
            Thread.sleep(10000);
            logger.info("threadTest end " + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.error("error", e);
        }
        model.setNum(number);
        return new AsyncResult<>(model);
    }
}
