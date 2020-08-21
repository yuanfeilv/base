package com.ambity.ribbon.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public synchronized String findUserByName() {
        return this.restTemplate.postForObject("http://restpay-ali-app/pay",new JSONObject(), String.class);
    }
}
