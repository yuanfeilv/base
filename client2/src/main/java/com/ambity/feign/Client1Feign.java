package com.ambity.feign;

//import com.ambity.client2.conguration.FeignConfiguration;
//import com.ambity.conguration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
//@FeignClient(name = "client1",fallbackFactory = Client1FallbackFactory.class,configuration = {FeignConfiguration.class})
//@FeignClient(name = "client1",fallbackFactory = Client1FallbackFactory.class)
@FeignClient(name = "client1")
public interface Client1Feign {
    @RequestMapping("client1")
    String client1();
    @RequestMapping("clienttest")
    String clienttest();
}
