package com.example.springbootthymeleaf.controller;

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
    public String show(){
        return "show";
    }
}
