package com.example.eurekaclientarticleservice.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        //实例化RestTemplate对象
        return  new RestTemplate();
    }
}
