package com.ambity;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.ambity.serivce"})
@EnableAspectJAutoProxy
public class Myconfig {
}
