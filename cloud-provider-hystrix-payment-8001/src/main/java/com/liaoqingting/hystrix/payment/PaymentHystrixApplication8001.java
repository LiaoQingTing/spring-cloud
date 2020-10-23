package com.liaoqingting.hystrix.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 2020/10/22 下午4:09
 */

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixApplication8001.class,args);
    }
}
