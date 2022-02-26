package com.example.springcloudribbon2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1")
public class TestController {

    @GetMapping("test1")
    public Object test(){
        return "567890";
    }
}