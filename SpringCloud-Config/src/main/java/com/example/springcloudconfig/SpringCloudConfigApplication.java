package com.example.springcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication是该类是SpringBoot的服务的启动入口
//@RestController是由@ResponseBody(返回数据为JSON)+@Controller控制器结合的注解，将此类交给Spring Boot
//@RequestMapping将此应用程序公开的URL以"/hi"，
//@EnableCircuitBreaker让程序能够使用Hystrix和Ribbon库
//@EnableEurekaClient让微服务使用Eureka服务发现代理去注册他自己，并将代码中使用服务发现远程查询REST服务端点
@SpringBootApplication
@RestController
@RequestMapping("hi")
public class SpringCloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigApplication.class, args);
    }

    //SpringBoot公开Get方法的REST端点和两个参数
    //@PathVariable是将URL中的参数映射到Hello中
    @RequestMapping(value="/{firstName}/{lastName}",method = RequestMethod.GET)
    public String Hello(@PathVariable("firstName") String firstName,
                        @PathVariable("lastName") String lastName){
        return "message:"+firstName+" "+lastName;
    }
}
