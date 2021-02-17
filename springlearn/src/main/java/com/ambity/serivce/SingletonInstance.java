package com.ambity.serivce;

public class SingletonInstance {

    public static class SingletonHolder{
        public static volatile SingletonInstance singleton = new SingletonInstance();
    }
    public static SingletonInstance getSingleton(){
        return SingletonHolder.singleton;
    }
}
//    static {
//        singleton = new SingletonInstance();
//    }