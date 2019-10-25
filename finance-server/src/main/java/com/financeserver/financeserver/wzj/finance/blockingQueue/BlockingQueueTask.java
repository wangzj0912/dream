package com.financeserver.financeserver.wzj.finance.blockingQueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.financeserver.financeserver.wzj.finance.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class BlockingQueueTask {

    private Logger log = LoggerFactory.getLogger(BlockingQueueTask.class);
    // 阻塞队列大小
    private final int MAX_VALUE = 10000;
    // 阻塞队列
    private BlockingQueue<User> queue = new LinkedBlockingDeque<>(MAX_VALUE);
    // 线程池
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    @Autowired
    private ObjectMapper mapper;

    public BlockingQueueTask() {
        excute();
    }

    public void excute() {
        executorService.scheduleWithFixedDelay(() -> {
            try {
                log.info("队列开始start");
                User user = queue.take();
                log.info("从队列中获取的数据：{}", user);
                deal(user);
                log.info("队列结束end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e2) {
                e2.printStackTrace();
            }
        }, 0, 1, TimeUnit.MINUTES);
    }


    /**
     * 向阻塞队列中增加数据
     *
     * @param user
     * @throws InterruptedException
     */
    public void addQueue(User user) throws InterruptedException {
        log.info("向队列中添加数据 start");
        queue.put(user);
        log.info("向队列中添加数据 end");
    }

    /**
     * 处理队列数据
     *
     * @param user
     */
    private void deal(User user) throws JsonProcessingException {
        System.out.println("处理队列数据：" + mapper.writeValueAsString(user));
    }

}
