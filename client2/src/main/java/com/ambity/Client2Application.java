package com.ambity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
@MapperScan(basePackages = {"com.ambity"})
public class Client2Application {
    public static ApplicationContext applicationContext = null;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Client2Application.class, args);
//        HystrixRequestContext.initializeContext();
    }
}
