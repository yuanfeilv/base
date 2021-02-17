package com.ambity.client3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest1Controller {
    @RequestMapping("client3")
    public String client1(){
        return "i am client3";
    }
}
