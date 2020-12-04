package com.ambity.client1;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@ConditionalOnBean(DataSource.class)
public class MyConfiguration {

}
