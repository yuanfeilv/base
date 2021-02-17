package com.ambity.sharesphere.controller;

import com.ambity.sharesphere.dto.Order;
import com.ambity.sharesphere.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("insert")
    public String insert(@RequestBody Order order)  {
        try{
            long a =orderMapper.insert(order);
            return String.valueOf(a);
        }catch (Exception e){
            e.printStackTrace();
        }
       return "ok";
    }
}
