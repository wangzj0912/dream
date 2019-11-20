package com.financeserver.wzj.finance.fegin;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://127.0.0.1:58883/websocket", name = "web-socket-api")
public interface WebSocketManageClient {

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    void sendMessage(@RequestBody String message);

}
