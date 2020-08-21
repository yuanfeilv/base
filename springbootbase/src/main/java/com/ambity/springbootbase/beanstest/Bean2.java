package com.ambity.springbootbase.beanstest;

public class Bean2 {
    private Bean1 bean1;
    public Bean2(Bean1 bean1){
        this.bean1 = bean1;
    }
    public void say(){
        bean1.say();
    }
}
