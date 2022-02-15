package com.example.springbootthymeleaf.Test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestTask {
    //cron属性时cron的表达式，由6-7个时间元素组成秒0-59  分0-59 时0-23 日期1-31 月1-12  年1970-2099
    @Async
    @Scheduled(cron = "*/2 * * * * ?")
    public void task01()throws Exception{
        System.out.println("Task01开始，线程id=>"+Thread.currentThread().getId()+"   "+new Date());
        Thread.sleep(10000);
        System.out.println("Task01结束，线程id=>"+Thread.currentThread().getId()+"   "+new Date());
    }
    @Async
    @Scheduled(cron = "*/4 * * * * ?")
    public void task02()throws Exception{
        System.out.println("Task02开始，线程id=>"+Thread.currentThread().getId()+"   "+new Date());
        Thread.sleep(4000);
        System.out.println("Task02结束，线程id=>"+Thread.currentThread().getId()+"   "+new Date());
    }
}
