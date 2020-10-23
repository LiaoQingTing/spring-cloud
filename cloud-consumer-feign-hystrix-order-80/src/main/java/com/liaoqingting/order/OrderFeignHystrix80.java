package com.liaoqingting.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 2020/10/22 下午4:59
 */

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class OrderFeignHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrix80.class,args);
    }
}
