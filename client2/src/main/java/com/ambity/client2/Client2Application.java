package com.ambity.client2;

import com.ambity.client2.feign.Client1Feign;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
public class Client2Application {
    public static ApplicationContext applicationContext = null;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Client2Application.class, args);
        HystrixRequestContext.initializeContext();
    }
}
