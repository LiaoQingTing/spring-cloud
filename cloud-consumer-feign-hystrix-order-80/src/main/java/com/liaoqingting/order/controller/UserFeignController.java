package com.liaoqingting.order.controller;

import com.liaoqingting.order.service.UserFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 2020/10/22 下午5:01
 */

@RestController
@Log4j2
public class UserFeignController {

    @Resource
    private UserFeignService userFeignService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id")int id){
        return userFeignService.paymentInfoOK(id)+"端口号："+serverPort;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "200")
    })
    public String paymentInfoTimeOut(@PathVariable("id")int id){
        log.info("访问了timeout");
        return userFeignService.paymentInfoTimeOut(id)+"端口号："+serverPort;
    }
    public String paymentInfoTimeOutHandler(int id){
        return "出错啦，兜底啦id="+id;
    }
}
