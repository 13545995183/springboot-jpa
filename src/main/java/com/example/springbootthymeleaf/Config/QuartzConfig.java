package com.example.springbootthymeleaf.Config;

import com.example.springbootthymeleaf.Test.JobTest1;
import com.example.springbootthymeleaf.Test.JobTest2;
import com.example.springbootthymeleaf.Test.JobTest3;
import org.apache.naming.factory.BeanFactory;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    public class Job1{
        @Bean
        public JobDetail createJobDetail1(){
            return JobBuilder.newJob(JobTest1.class).withIdentity("JobTest1").storeDurably().build();
        }
        @Bean
        public Trigger createTrigger1(){
            SimpleScheduleBuilder scheduleBuilder=SimpleScheduleBuilder.simpleSchedule()
                    //设置时间周期
                    .withIntervalInSeconds(2)
                    //执行次数，不限制次数
                    .repeatForever();
            SimpleTrigger trigger=TriggerBuilder.newTrigger().forJob(createJobDetail1())
                    .withIdentity("TestJob1Trigger").withSchedule(scheduleBuilder).build();

            return  trigger;
        }
    }
    public class Job2{
        @Bean
        public JobDetail createJobDetail2(){
            return JobBuilder.newJob(JobTest2.class).withIdentity("JobTest2").storeDurably().build();
        }
        @Bean
        public Trigger createTrigger2(){
            SimpleScheduleBuilder scheduleBuilder=SimpleScheduleBuilder.simpleSchedule()
                    //设置时间周期
                    .withIntervalInSeconds(4)
                    //设置限制次数
                    .withRepeatCount(3);
            SimpleTrigger trigger=TriggerBuilder.newTrigger().forJob(createJobDetail2())
                    .withIdentity("TestJob2Trigger").withSchedule(scheduleBuilder).build();
            return  trigger;
        }
    }
    public class Job3{
        @Bean
        public JobDetail createJobDetail3(){
            return JobBuilder.newJob(JobTest3.class).withIdentity("JobTest3").storeDurably().build();
        }
        /**/
        @Bean
        public Trigger createTrigger3(){
            //基于Quartz Cron表达式的调度任务构造器
            CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule("*/4 * * * * ?");
            CronTrigger cronTrigger=TriggerBuilder.newTrigger().forJob(createJobDetail3())
                    .withIdentity("TestJob3Trigger")
                    .withSchedule(scheduleBuilder)
                    .build();
            return  cronTrigger;
        }
    }
}
