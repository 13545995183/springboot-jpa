package com.example.springcloudribbon3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudRibbon3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbon3Application.class, args);
    }

}
