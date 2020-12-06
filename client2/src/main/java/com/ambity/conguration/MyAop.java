//package com.ambity.client2.conguration;
//
//import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Aspect
//@Component
//public class MyAop {
//    @Pointcut("execution(public * com.ambity.client2.controller.*.*(..))")
//    public void in(){
//
//    }
//    @Around("in()")
//    public Object inAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        if (!HystrixRequestContext.isCurrentThreadInitialized()){
//            HystrixRequestContext.initializeContext();
//        }
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        HttpServletRequest httpRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
//        ContextHolder.md.set("1111");
//        Object returnObj = joinPoint.proceed();
//        HystrixRequestContext.getContextForCurrentThread().shutdown();
//        return returnObj;
//    }
//}
