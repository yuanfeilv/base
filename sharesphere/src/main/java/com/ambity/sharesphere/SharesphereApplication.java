package com.ambity.sharesphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.ambity.sharesphere.mapper"})
public class SharesphereApplication {
    public static void main(String[] args) {
        SpringApplication.run(SharesphereApplication.class, args);
    }
}
