package com.ambity.proxy;

import net.sf.cglib.proxy.Enhancer;

public class SayMain {
    public static void main(String[] args) {
//        MySay mySay = new MySay();
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibProxy());
        enhancer.setSuperclass(MySay.class);
        MySay mySay1 = (MySay) enhancer.create();
        mySay1.saySomething();
//        MyProxy myProxy = new MyProxy();
////        myProxy.setTarget(mySay);
////        SayInterface sayInterface =  (SayInterface) myProxy.getProxy();
////        sayInterface.saySomething();
    }
}
