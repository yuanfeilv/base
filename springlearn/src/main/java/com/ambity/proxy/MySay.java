package com.ambity.proxy;

public class MySay implements SayInterface{
    @Override
    public void saySomething() {
        System.out.println("I am cool");
    }
}
