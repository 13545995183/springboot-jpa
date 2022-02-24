package com.example.springcloudhystrix.controller;

import com.netflix.hystrix.Hystrix;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariable;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableLifecycle;
import org.apache.catalina.startup.UserConfig;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class HystrixThreadLocal extends HystrixConcurrencyStrategy {
    private HystrixConcurrencyStrategy hystrixConcurrencyStrategy;
    //将已存在并发策略传入HystrixThreadLocal类构造器中
    public HystrixThreadLocal(HystrixConcurrencyStrategy hystrixConcurrencyStrategy){
        this.hystrixConcurrencyStrategy=hystrixConcurrencyStrategy;
    }
    //要么调用HystrixThreadLocal，要么调用HystrixConcurrencyStrategy
    public BlockingQueue<Runnable> getBlockingQueue(int maxQueueSize){
        return hystrixConcurrencyStrategy!=null
                ?hystrixConcurrencyStrategy.getBlockingQueue(maxQueueSize)
                :super.getBlockingQueue(maxQueueSize);
    }

}
