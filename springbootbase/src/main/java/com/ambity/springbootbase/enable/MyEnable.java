package com.ambity.springbootbase.enable;

import com.ambity.springbootbase.compontscantest.ImportBeanDefinitionRegistrarTest;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ImportBeanDefinitionRegistrarTest.class)
public @interface MyEnable {
    String basePackages();
}
