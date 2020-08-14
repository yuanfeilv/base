package com.ambity.springbootbase.annotation;

import com.ambity.springbootbase.condition.MyCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(MyCondition.class)
public @interface MyConditionAnno {
    String value();
    String key();
}
