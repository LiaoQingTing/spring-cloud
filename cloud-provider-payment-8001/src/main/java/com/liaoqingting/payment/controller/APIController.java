package com.liaoqingting.payment.controller;

import com.liaoqingting.payment.service.UserService;
import com.liaoqingting.springcloud.model.CommonResult;
import com.liaoqingting.springcloud.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/get/{id}")
    public CommonResult<User> getUserById(@PathVariable("id")Integer id){
        return new CommonResult<>(200,  "success", userService.getUserById(id));
    }
    @PostMapping("/user/put")
    public CommonResult<Integer> putUser(@RequestBody User user){
        return new CommonResult<>(200,"success",userService.insertUser(user));
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
