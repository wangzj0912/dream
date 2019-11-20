package com.financeserver.wzj.finance.controller;

import com.financeserver.wzj.finance.blockingQueue.BlockingQueueTask;
import com.financeserver.wzj.finance.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockingQueueController {

    @Autowired
    BlockingQueueTask blockingQueueTask;

    @ApiOperation(value = "向阻塞队列中添加数据", notes = "向阻塞队列中添加数据")
    @PostMapping(value = "/addQueue")
    public void addQueue(@RequestBody User user)throws InterruptedException{
        blockingQueueTask.addQueue(user);
    }
}
