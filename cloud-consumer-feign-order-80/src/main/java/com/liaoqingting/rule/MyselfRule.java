package com.liaoqingting.rule;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 2020/10/22 下午1:37
 *
 *  ribbon 负载均衡配置类
 */

@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule(){
        //return new BestAvailableRule();
        return new RandomRule();
    }
}
