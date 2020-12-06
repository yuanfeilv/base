//package com.ambity.conguration;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class FeignRequestInterceptor implements RequestInterceptor {
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        log.info(ContextHolder.md.get());
//        requestTemplate.header("name",ContextHolder.md.get());
//    }
//}
