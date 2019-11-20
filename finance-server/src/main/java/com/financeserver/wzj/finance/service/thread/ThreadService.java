package com.financeserver.wzj.finance.service.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author wangzhaojian
 * @Date 2019/11/8 16:23
 */
@Service
public class ThreadService {

    private Logger logger = LoggerFactory.getLogger(ThreadService.class);

    public Integer getNumber(){
        try{
            logger.info("test start "+ new Date());
            // 10秒后获得数据
            Thread.sleep(10000);
            logger.info("test end "+ new Date());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return 1;
    }

}
