package com.ambity.client3.hystrix;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * FeignInterceptor 实现类，用于在feign 的loadBalanceClient 调用前执行，
 * 通常这里可以用来传递值，如 相同的权限信息
 */
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        // todo 这里如果是和hystrix 一起使用，RequestContextHolder 无法拿到调用线程的上线文，此时需要设置hystrix 的类来实现
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (null != requestAttributes && requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest httpRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (null != httpRequest) {
                template.header("auth","your auth");
            }
        }
    }
}