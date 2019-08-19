package com.financeserver.financeserver.wzj.finance.fegin;

import com.financeserver.financeserver.wzj.finance.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user-server")
public interface UserFeign {

    @GetMapping(value = "/user/getUserById")
    @ResponseBody
    public User getUserById(@RequestParam String id) throws Exception;

    @GetMapping(value = "/user/getUser/{id}")
    @ResponseBody
    public User getUser(@RequestParam String name) throws Exception;

    @GetMapping(value = "/user/getUserTest")
    @ResponseBody
    public User getUserTest() throws Exception;

    @PostMapping(value = "/user/postUserTest")
    @ResponseBody
    public User postUserTest(@RequestBody User user) throws Exception;
}
