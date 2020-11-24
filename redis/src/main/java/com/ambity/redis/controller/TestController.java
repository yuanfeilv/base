package com.ambity.redis.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    RedissonClient redissonClient;

    @RequestMapping("/test")
    public String test() throws InterruptedException {
        redissonClient.getMap("rest").fastPut("filed","value");
        System.out.println(redissonClient.getMap("rest").get("filed"));
        RLock lock = redissonClient.getLock("abbc");
        lock.lock();
        Thread.sleep(200000);
        lock.unlock();
        return "";
    }
}
