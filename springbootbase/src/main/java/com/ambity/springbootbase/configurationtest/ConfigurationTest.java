package com.ambity.springbootbase.configurationtest;

import com.ambity.springbootbase.annotation.MyConditionAnno;
import com.ambity.springbootbase.beanstest.Bean1;
import com.ambity.springbootbase.beanstest.Bean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationTest {
    @Bean
    public Bean1 bean1(){
        return new Bean1();
    }

    @Bean
    public Bean2 bean2(Bean1 beantest){
        return new Bean2(beantest);
    }

}
