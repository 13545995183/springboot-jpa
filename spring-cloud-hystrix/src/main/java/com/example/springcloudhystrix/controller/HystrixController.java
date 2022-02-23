package com.example.springcloudhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class HystrixController {
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/getProductInfo")
    public String getProductInfo(){
        RestTemplate r=new RestTemplate();
        String result=r.postForObject("http://localhost:8085/user/hello",
                Arrays.asList("157875227953464068"),String.class);
        return result;
    }

    //降级之后具体处理的业务方法
    public String fallback(){
        return "请求太热情，请稍后再试";
    }
    @HystrixCommand
    public String getFindAll(){

        return null;
    }
}
