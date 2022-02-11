package com.example.springbootthymeleaf.Test;

import com.example.springbootthymeleaf.entity.Employee;
import com.example.springbootthymeleaf.entity.user;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

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

        //获取左侧第一个元素
        //System.out.println(redisTemplate.opsForList().index("emps",0));
        Employee e= (Employee) redisTemplate.opsForValue().get("emp1");
        System.out.println(e.getName());
    }
    @GetMapping("update")
    void updatename(){
        redisTemplate.opsForValue().set("name","钱多多");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
    @GetMapping("list")
    void list(){
        String[] a={"钱多多","牵涉"};
        redisTemplate.opsForList().leftPush("emps","力争");
        redisTemplate.opsForList().leftPushAll("emps",a);
        List<String> list=new ArrayList<>();
        list.add("牵涉到死");
        list.add("到死");
        redisTemplate.opsForList().leftPushAll("emps",list);

    }
    @GetMapping("saveObject")
    void object(){
        Employee e=new Employee();
        e.setNumber(1111);
        e.setAge(111);
        e.setName("你好");
        e.setId(1);
        redisTemplate.opsForValue().set("emp1",e);
    }

}
