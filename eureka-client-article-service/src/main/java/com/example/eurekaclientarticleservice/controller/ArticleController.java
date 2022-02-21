package com.example.eurekaclientarticleservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ArticleController {
    //注入配置的restTemplate
    @Autowired
    private RestTemplate restTemplate;

    //服务消费者
    @GetMapping("/article/callHello")
    public String callHello() {
        // 1）直接调用接口
        return restTemplate.getForObject("http://localhost:8085/user/hello", String.class);
    }

    //服务消费者
    @GetMapping("/article/callHello2")
    public String callHello2() {
        // 2）通过 Eureka 来消费接口,restTemplate配置类前面需要添加 @LoadBalanced
        return restTemplate.getForObject("http://eureka-client-user-service/user/hello", String.class);
    }
}