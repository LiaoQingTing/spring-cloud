package com.liaoqingting.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 2020/10/22 下午5:01
 */
@Component
@FeignClient("CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface UserFeignService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentInfoOK(@PathVariable("id") int id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") int id);
}
