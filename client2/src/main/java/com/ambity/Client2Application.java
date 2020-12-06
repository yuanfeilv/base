package com.ambity;

import com.alibaba.cloud.seata.feign.SeataFeignClientAutoConfiguration;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
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
