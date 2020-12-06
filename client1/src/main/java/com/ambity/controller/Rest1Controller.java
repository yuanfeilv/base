package com.ambity.controller;

import com.ambity.dto.Tb1;
import com.ambity.mapper.Tb1Mapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

@RestController
public class Rest1Controller {
    @Autowired
    Tb1Mapper tb1Mapper;
    @RequestMapping("/client1")
//    @GlobalTransactional
    @Transactional
    public String client1(){
        Tb1 tb1 = tb1Mapper.selectByPrimaryKey(1);
        System.out.println(RootContext.getXID());
        tb1.setValue("client1");
        tb1Mapper.updateByPrimaryKey(tb1);
        throw new RuntimeException("111");
//        return "ok";
    }
}
