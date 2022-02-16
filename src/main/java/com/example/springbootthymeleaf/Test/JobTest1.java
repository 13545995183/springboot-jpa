package com.example.springbootthymeleaf.Test;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class JobTest1 extends QuartzJobBean {
    //需要executeInternal()方法，JobExecutionContext提供调度的上下文信息
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job1开始线程："+Thread.currentThread().getId());
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Job1结束线程："+Thread.currentThread().getId());
    }
}
