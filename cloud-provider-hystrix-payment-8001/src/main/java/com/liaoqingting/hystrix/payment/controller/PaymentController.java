package com.liaoqingting.hystrix.payment.controller;

import com.liaoqingting.hystrix.payment.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 2020/10/22 下午4:15
 */

@RestController
@Log4j2
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id")int id){
        return paymentService.paymentInfoOK(id)+" 端口号："+serverPort +" id:"+id;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id")int id){
        log.info("访问了timeout");
        return paymentService.paymentInfoTimeOut(id)+" 端口号："+serverPort+" id:"+id;
    }
}
