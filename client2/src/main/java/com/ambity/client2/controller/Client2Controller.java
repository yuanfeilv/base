package com.ambity.client2.controller;

import com.ambity.client2.conguration.ContextHolder;
import com.ambity.client2.feign.Client1Feign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Client2Controller {
    @Autowired
    private Client1Feign client1Feign;
    @RequestMapping("client2")
    public String client2(String name){
        log.info(name);
        ContextHolder.md.set(name);
        return client1Feign.client1();
    }
}
