package com.example.springcloudribbon2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudRibbon2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbon2Application.class, args);
    }

}
