package com.ambity.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class TestController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    public String test(){
        redisTemplate.opsForValue().set("aab","222");
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end ";
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(script,Long.class);
        // 参数一：redisScript，参数二：key列表，参数三：arg（可多个）
        long result = stringRedisTemplate.execute(redisScript, Collections.singletonList("aac"),"222");
        System.out.println(result);
        return redisTemplate.opsForValue().get("aab");
    }
}
