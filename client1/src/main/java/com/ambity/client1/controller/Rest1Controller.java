package com.ambity.client1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
public class Rest1Controller {
    @RequestMapping("client1")
    public String client1() throws Exception{
        System.out.println("进入超时逻辑");
        System.out.println("进入超时退出");
        return "i am client3";
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        System.out.println("期待任务执行");
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("任务执行");
            }
        },1, TimeUnit.MINUTES);
    }
}
