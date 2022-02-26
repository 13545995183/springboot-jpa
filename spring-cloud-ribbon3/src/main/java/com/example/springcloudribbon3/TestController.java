package com.example.springcloudribbon3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test3")
public class TestController {

    @GetMapping("/test3")
    public Object test(){
        return "789JQK";
    }
}