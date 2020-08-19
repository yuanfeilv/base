package com.ambity.client2.controller;

import com.ambity.client2.feign.Client1Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Client2Controller {
    @Autowired
    private Client1Feign client1Feign;
    @RequestMapping("client2")
    public String client2(){
        return client1Feign.client1();
    }
}
