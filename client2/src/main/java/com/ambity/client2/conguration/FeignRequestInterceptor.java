package com.ambity.client2.conguration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 要结合RequestAttributeAwareCallableWrapper.class一起使用，否则取到的值为null
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (null != requestAttributes && requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest httpRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (null != httpRequest) {
                System.out.println(111);
            }
        }
    }
}
