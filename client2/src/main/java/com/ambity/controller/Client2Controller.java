package com.ambity.controller;

//import com.ambity.conguration.ContextHolder;
import com.ambity.dto.Tb2;
import com.ambity.feign.Client1Feign;
import com.ambity.mapper.Tb2Mapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Client2Controller {
    @Autowired
    private Client1Feign client1Feign;

    @Autowired
    private Tb2Mapper tb2Mapper;
    @RequestMapping("client2")
    @GlobalTransactional(name = "client2-client1",rollbackFor = Exception.class)
    public String client2(String name){
        Tb2 tb2 = new Tb2();
        tb2.setId(1);
        tb2.setValue("client2");
        tb2Mapper.updateByPrimaryKeySelective(tb2);
        try {
            client1Feign.client1();
        }catch (Exception e){

        }
        System.out.println(RootContext.getXID());
//        ContextHolder.md.set(name);
        return "ok";
    }
}
