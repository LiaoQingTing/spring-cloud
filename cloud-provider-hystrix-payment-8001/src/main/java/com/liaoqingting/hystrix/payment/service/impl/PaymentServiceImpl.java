package com.liaoqingting.hystrix.payment.service.impl;

import com.liaoqingting.hystrix.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 2020/10/22 下午4:12
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfoOK(int id) {
        return "线程池："+Thread.currentThread().getName()+"\t paymentInfoOK";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfoTimeOut(int id) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"\t paymentInfoTimeOut";
    }
    public String paymentInfoTimeOutHandler(int id){

        return "线程池："+Thread.currentThread().getName()+"\t paymentInfoTimeOutHandler 服务降级";

    }
}
