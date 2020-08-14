package com.ambity.springbootbase;

import com.ambity.springbootbase.compontscantest.CompontScanFilter;

import com.ambity.springbootbase.compontscantest.ImportBeanDefinitionRegistrarTest;
import com.ambity.springbootbase.compontscantest.ImportSelectTest;
import com.ambity.springbootbase.enable.MyEnable;
import com.ambity.springbootbase.importtest.ImportTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.List;

@Import({ImportTest.class, ImportSelectTest.class})
@MyEnable(basePackages="com.ambity.springbootbase")
@ComponentScan(basePackages = {"com.ambity.springbootbase"},excludeFilters = {@ComponentScan.Filter(type=FilterType.CUSTOM,classes = CompontScanFilter.class)})
@SpringBootApplication
public class SpringbootbaseApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext =  SpringApplication.run(SpringbootbaseApplication.class, args);
        String [] appnames = applicationContext.getBeanDefinitionNames();
        List<String> list = Arrays.asList(appnames);
        list.stream().forEach((String string)->System.out.println(string));
    }
}
