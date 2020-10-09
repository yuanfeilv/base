package com.ambity.client2.feign;

//import com.ambity.client2.conguration.FeignConfiguration;
import com.ambity.client2.conguration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "client1",fallbackFactory = Client1FallbackFactory.class,configuration = {FeignConfiguration.class})
public interface Client1Feign {
    @RequestMapping("client1")
    String client1();
}
