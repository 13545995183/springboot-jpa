package com.example.springbootthymeleaf;

import com.example.springbootthymeleaf.entity.user;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class TestController {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /*@RequestMapping("/test")
    public ModelAndView test(HttpSession session) {
        ModelAndView view=new ModelAndView("test");
        view.addObject("msg","<h1>hello world<h1>");
        user u=new user();
        u.setAge(11);
        u.setPhone("11111111");
        u.setUsername("qs");
        u.setSex("男");
        view.addObject("time",new Date());
        view.addObject("user",u);
        session.setAttribute("role","管理员");
        return view;
    }*/

    @GetMapping("setname")
    void setString(){
        redisTemplate.opsForValue().set("name","tom");
    }

    @GetMapping("getname")
    void getString(){

        System.out.println();
    }

}
