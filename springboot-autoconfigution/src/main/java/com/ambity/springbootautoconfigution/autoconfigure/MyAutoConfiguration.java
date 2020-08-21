package com.ambity.springbootautoconfigution.autoconfigure;

import com.ambity.springbootautoconfigution.bean.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAutoConfiguration {
    @Bean
    public TestBean testBean(){
        return new TestBean();
    }
}
