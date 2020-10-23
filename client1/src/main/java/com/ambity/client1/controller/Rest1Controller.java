package com.ambity.client1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    @PostMapping("test2")
    public String test2(@RequestParam LinkedHashMap<String,Object> map, HttpServletRequest request) throws Exception{
        System.out.println(request.getAttributeNames());
//        List<String> list = (List<String>) request.getAttributeNames();
        Set<String> set = map.keySet();
        for (String string:set){
            System.out.println(string);
        }
        return "i am client3";
    }

    public static void main(String[] args) {
        Map map = new LinkedHashMap();
        map.put("cc","bbb");
        System.out.println(String.valueOf(map.get("aa")));
    }
}
