package com.liaoqingting.payment8001.controller;

import com.liaoqingting.payment8001.service.UserService;
import com.liaoqingting.springcloud.model.CommonResult;
import com.liaoqingting.springcloud.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Log4j2
@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    private UserService userService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/user/get/{id}")
    public CommonResult<User> getUserById(@PathVariable("id")Integer id){
        log.info("查询成功 端口号："+serverPort);
//        try{
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return new CommonResult<>(200,  "success:"+serverPort, userService.getUserById(id));
    }
    @PostMapping("/user/put")
    public CommonResult<Integer> putUser(@RequestBody User user){
        return new CommonResult<>(200,"success:"+serverPort,userService.insertUser(user));
    }
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String element: services){
            log.info("element: "+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance serviceInstance : instances){
            log.info(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return discoveryClient;
    }
}
