package com.userserver.userserver.wzj.user.controller;

import com.userserver.userserver.wzj.user.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
@Api(value = "用户信息操作")
public class UserController {

    private Logger log = Logger.getLogger("UserController.java");

    @GetMapping(value = "/getUserById")
    @ApiOperation(value = "用户信息查询 BY ID")
    public User getUserById(@RequestParam("id") String id) {
        log.info("user.id = " + id);
        User user = new User();
        user.setId(id);
        user.setName("wzj");
        return user;
    }

    @GetMapping(value = "/getUser/{id}")
    @ApiOperation(value = "用户信息查询")
    public User getUser(@PathVariable String id,@RequestParam String name){
        log.info("path 下的 user.id = " + id);
        log.info("param 下的 user.name = " + name);
        User userNew = new User();
        userNew.setId(id);
        userNew.setName(name);
        return userNew;
    }

    @GetMapping(value = "/getUserTest")
    @ApiOperation(value = "用户信息查询")
    public User getUserTest(){
        log.info("path 下的 user.id = " + "test 无参feign");
        User user = new User();
        user.setId("123");
        user.setName("ll");
        return user;
    }

    @PostMapping(value = "/postUserTest")
    @ApiOperation(value = "用户信息修改")
    public User postUserTest(@RequestBody User user){
        log.info("post 请求，有参修改 " + user.getName());

        return user;
    }

}
