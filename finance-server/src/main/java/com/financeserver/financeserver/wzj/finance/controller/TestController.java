package com.financeserver.financeserver.wzj.finance.controller;

import com.financeserver.financeserver.wzj.finance.fegin.UserFeign;
import com.financeserver.financeserver.wzj.finance.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Api(value = "测试")
@RestController
@RequestMapping(value = "/test")
public class TestController {
    private Logger log = Logger.getLogger("TestController.class");

    /**
     * 用户fegin
     */
    @Autowired UserFeign userFeign;

    @GetMapping("/usertest")
    @ApiOperation(value = "测试获取用户信息")
    public void getUser(){
        try{
            User user1 = userFeign.getUserTest();
            log.info("test one  " + user1.getId() + user1.getName());

            User user = userFeign.getUserById("1");
            log.info("test two  " + user.getId() + user.getName());


            user.setName("jj");
            User user2 = userFeign.postUserTest(user);
            log.info("test three  " + user2.getId() + user2.getName());


        } catch (Exception e){
            log.info("test error" + e);
        }
    }


}
