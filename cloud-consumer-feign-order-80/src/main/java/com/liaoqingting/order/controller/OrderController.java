package com.liaoqingting.order.controller;

import com.liaoqingting.order.service.UserFeignService;
import com.liaoqingting.springcloud.model.CommonResult;
import com.liaoqingting.springcloud.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 2020/10/22 下午1:06
 */
@RestController
@Log4j2
public class OrderController {

    @Resource
    private UserFeignService userFeignService;

    @GetMapping("/consumer/user/get/{id}")
    public CommonResult<User> getUserById(@PathVariable("id")int id){
        return userFeignService.getUserById(id);
    }
    @GetMapping("/consumer/user/put")
    public CommonResult<String> putUser(User user){
        return userFeignService.insertUser(user);
    }
}
