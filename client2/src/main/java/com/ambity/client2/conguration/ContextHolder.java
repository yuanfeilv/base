package com.ambity.client2.conguration;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;

public class ContextHolder {
    public static  HystrixRequestVariableDefault<String> md = new HystrixRequestVariableDefault();
}
