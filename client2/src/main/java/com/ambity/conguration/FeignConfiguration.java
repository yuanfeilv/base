//package com.ambity.conguration;
//
//import feign.Logger;
//import feign.RequestInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
///**
// * Feign调用的时候添加到请求头
// *
// * @author haijun.gao
// *
// */
//@Configuration
//public class FeignConfiguration {
//
//    @Bean
//    public RequestInterceptor requestInterceptor(){
//        return new FeignRequestInterceptor();
//    }
//
//    @Bean
//    public Logger.Level feignLog(){
//        return Logger.Level.FULL;
//    }
//}
