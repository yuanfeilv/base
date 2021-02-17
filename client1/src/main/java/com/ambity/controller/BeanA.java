package com.ambity.controller;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanA {
   private String name;
    private int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    @PostConstruct
    public void postConstruent(){
         System.out.println("aaa");
    }

    public static void main(String[] args) {

    }
}
