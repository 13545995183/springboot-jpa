package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.Test.JobTest1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("login")
    public String login(){
        return "login";
    }
    @GetMapping("loginError")
    public String loginError(){
        return "loginError";
    }
    @GetMapping("show")
    public void show(){


        //return "show";
    }
}
