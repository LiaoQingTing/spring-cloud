package com.liaoqingting.order.service;

import com.liaoqingting.springcloud.model.CommonResult;
import com.liaoqingting.springcloud.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 2020/10/22 下午1:00
 */

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
@RequestMapping("/api")
public interface UserFeignService {

    @GetMapping("/user/get/{id}")
    CommonResult<User> getUserById(@PathVariable("id") int id);

    @PostMapping("/user/put")
    CommonResult<String> insertUser(@RequestBody User user);
}
