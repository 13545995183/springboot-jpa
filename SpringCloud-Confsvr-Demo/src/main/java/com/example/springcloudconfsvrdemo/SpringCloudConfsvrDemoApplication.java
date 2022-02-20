package com.example.springcloudconfsvrdemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
//@EnableConfigServer使服务称为Spring Cloud Config服务
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfsvrDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfsvrDemoApplication.class, args);
    }

}
