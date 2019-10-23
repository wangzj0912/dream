package com.financeserver.financeserver.wzj.finance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.financeserver.financeserver.wzj.finance.fegin.UserFeign;
import com.financeserver.financeserver.wzj.finance.fegin.WebSocketManageClient;
import com.financeserver.financeserver.wzj.finance.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试")
@RestController
@RequestMapping(value = "/test")
public class FeignTestController {
    private Logger log = LoggerFactory.getLogger(FeignTestController.class);

    /**
     * 用户fegin
     */
    @Autowired UserFeign userFeign;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    WebSocketManageClient webSocketManageClient;

    @GetMapping("/usertest")
    @ApiOperation(value = "测试获取用户信息")
    public void getUser(){
        try{
//            User user1 = userFeign.getUserTest();
//            log.info("test one  " + user1.getId() + user1.getName());
//
//            User user = userFeign.getUserById("1");
//            log.info("test two  " + user.getId() + user.getName());
//
//
//            user.setName("jj");
//            User user2 = userFeign.postUserTest(user);
//            log.info("test three  " + user2.getId() + user2.getName());
//
//            User usert = new User();
//            usert.setName("123");
//            usert.setId("456");
//            String str = "user : 123" ;
//
//            log.info("start");
//
//            userFeign.testRequestBody(mapper.writeValueAsString(user));
//
//            userFeign.testRequestBody(str);
//
//            userFeign.testRequestParam(mapper.writeValueAsString(user));
//
//            userFeign.testRequestParam(str);
//
//            log.info("end");

            User user = new User();
            System.out.println(mapper.writeValueAsString(user));
            webSocketManageClient.sendMessage(mapper.writeValueAsString(user));


        } catch (Exception e){
            log.info("test error" + e);
        }
    }


}
