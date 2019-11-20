package com.financeserver.wzj.finance.controller;

import com.financeserver.wzj.finance.model.ThreadModel;
import com.financeserver.wzj.finance.service.thread.ThreadService;
import com.financeserver.wzj.finance.service.thread.ThreadTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.Future;

/**
 * @Author wangzhaojian
 * @Date 2019/11/8 16:16
 */
@RestController
public class ThreadController {

    @Autowired
    private ThreadService threadService;
    @Autowired ThreadTestService threadTestService;
    private Logger logger = LoggerFactory.getLogger(ThreadController.class);

    /**
     * 异步查询数据
     * 1、通过线程处理
     */
    @PostMapping("/testByThread")
    public void testByThread() {
        try {
            logger.info("001: " + new Date());
            // 线程1在处理
            Future<ThreadModel> future =threadTestService.task(1);
            // 线程2（主线程）在处理
            int num1 = threadService.getNumber();
            //线程1 获取数据（线程1处理完则获取数据，线程1处理中则阻塞）
            ThreadModel threadModel = future.get();

            logger.info("003: " + new Date());

            logger.info(String.valueOf(num1 + threadModel.getNum()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步查询数据
     * 1、通过@Async注解来处理
     */
    @PostMapping("/testByAsync")
    public void testByAsync() {


    }
}
