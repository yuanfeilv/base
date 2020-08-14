package com.ambity.springbootbase.configurationtest;

import com.ambity.springbootbase.annotation.MyConditionAnno;
import com.ambity.springbootbase.beanstest.Bean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationTest {
    @Bean
    @MyConditionAnno(value = "11",key = "22")
    public Bean1 bean1(){
        return new Bean1();
    }
}
