package com.ambity.client1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest1Controller {
    @RequestMapping("client1")
    public String client1(){
        return "i am client1";
    }
}
