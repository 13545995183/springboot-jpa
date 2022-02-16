package com.example.springbootthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
* EnableCaching开启缓存
* */
@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableAsync
public class SpringbootThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootThymeleafApplication.class, args);
    }

}
