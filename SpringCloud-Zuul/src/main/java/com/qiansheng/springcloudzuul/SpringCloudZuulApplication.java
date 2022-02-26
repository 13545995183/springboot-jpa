package com.qiansheng.springcloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class SpringCloudZuulApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringCloudZuulApplication.class, args);
    }
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello " + name;
    }
}
