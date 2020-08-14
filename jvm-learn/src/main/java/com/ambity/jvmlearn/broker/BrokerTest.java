package com.ambity.jvmlearn.broker;

public class BrokerTest {
    public static void main(String[] args) throws ClassNotFoundException {
        BrokerClassLoader brokerClassLoader = new BrokerClassLoader("D:\\study\\learn\\src\\main\\java");
        Class clasz = brokerClassLoader.loadClass("com.ambity.learn.broker.User");
        System.out.println(clasz.getClassLoader());
    }
}
