package com.liaoqingting.order.controller;

import com.liaoqingting.springcloud.model.CommonResult;
import com.liaoqingting.springcloud.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 10/20/20 3:26 PM
 */

@Log4j2
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/consumer/user/get/{id}")
    public CommonResult<User> getUserById(@PathVariable("id")int id){
        return restTemplate.getForObject(PAYMENT_URL+"/api/user/get/"+id,CommonResult.class);
    }
    @GetMapping("/consumer/user/put")
    public CommonResult<String> putUser(User user){
        return restTemplate.postForObject(PAYMENT_URL+"/api/user/put",user,CommonResult.class);
    }
}
