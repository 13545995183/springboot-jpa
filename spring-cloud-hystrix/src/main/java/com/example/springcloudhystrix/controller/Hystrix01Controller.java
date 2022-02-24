package com.example.springcloudhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hystrix01Controller {
    @HystrixCommand(
            fallbackMethod = "fallback",
            //创建独立的线程池
            threadPoolKey = "licenseThreadPool",
            threadPoolProperties = {
                    //线程池大小
                    @HystrixProperty(name="coreSize" ,value="30"),
                    //线程池最大队列的数量
                    @HystrixProperty(name="maxQueueSize" ,value="10")
            },
            //commandProperties是定制与Hystrix命令关联断路器。
            //ciruitBreaker.requestVolumeThreshold用于控制Hystrix考虑在断路器跳闸之前，在10秒内必须发生的连续调用。
            //ciruitBreaker.errorThresholdPercentage是在超过ciruitBreaker.requestVolumeThreshold值之后，在断路器之前必须打到的调用失败（由于超时。异常）百分比
            //ciruitBreaker.sleepWindowInMillseconds是在断路器跳闸之后，Hystrix允许另一个调用通过以便查看服务是否恢复健康Hystrix的休眠时间。
            //metrics.rollingStats.timeInMilliseconds控制Hystrix监视服务调用问题的窗口大小，其默认值为10000ms
            //metrics.rollingStats.numBuckets设置的值必须被定义桶的数量值。
            commandProperties = {
                    @HystrixProperty(name="ciruitBreaker.requestVolumeThreshold" ,value="10"),
                    @HystrixProperty(name="ciruitBreaker.errorThresholdPercentage" ,value="75"),
                    @HystrixProperty(name="ciruitBreaker.sleepWindowInMillseconds" ,value="7000"),
                    @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds" ,value="15000"),
                    @HystrixProperty(name="metrics.rollingStats.numBuckets" ,value="5")
            }
    )
    @RequestMapping("getLicenses")
    public String getLicenses(){
        return "ok";
    }
    public String fallback(){
        return "fallback:error message";
    }
    @RequestMapping("setContext")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy",value="SEMAPHORE")
    })
    public void setContext(){
        System.out.println("setContext");
    }
}
