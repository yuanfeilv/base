package com.ambity.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


@Component
public class Client1FallbackFactory implements FallbackFactory<Client1Feign> {
    @Override
    public Client1Feign create(Throwable throwable) {
        System.out.println(throwable.getMessage());
        return new Client1Feign(){

            @Override
            public String client1() {
                return "client1 fallack";
            }

            @Override
            public String clienttest() {
                return "clienttest fallack";
            }
        };
    }
}
