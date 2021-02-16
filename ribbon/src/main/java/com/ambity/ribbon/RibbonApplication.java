package com.ambity.ribbon;

import com.ambity.ribbon.Irule.Myrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
// RibbonClient 中的value 是服务名，configuration 是自定义的策略类
@RibbonClients(value = {@RibbonClient(value = "restpay-ali-app",configuration = Myrule.class)})
public class RibbonApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =  SpringApplication.run(RibbonApplication.class, args);
        Object appnames = applicationContext.getBeanDefinitionNames();
        System.out.println(appnames.getClass());
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
