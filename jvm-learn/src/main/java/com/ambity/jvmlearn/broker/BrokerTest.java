package com.ambity.jvmlearn.broker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BrokerTest {
    public static void main(String[] args) throws ClassNotFoundException {
//        BrokerClassLoader brokerClassLoader = new BrokerClassLoader("D:\\study\\learn\\src\\main\\java");
//        Class clasz = brokerClassLoader.loadClass("com.ambity.learn.broker.User");
//        System.out.println(clasz.getClassLoader());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,2,5, TimeUnit.HOURS,new ArrayBlockingQueue<>(5),new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(111);
            }
        });
    }
}
