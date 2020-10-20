package com.liaoqingting.payment.controller;

import com.liaoqingting.payment.service.UserService;
import com.liaoqingting.springcloud.model.CommonResult;
import com.liaoqingting.springcloud.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    private UserService userService;
    @RequestMapping("/user/get/{id}")
    public CommonResult<User> getUserById(@PathVariable("id")Integer id){
        return new CommonResult<>(200,  "success", userService.getUserById(id));
    }
}
