package com.ambity.client1.controller;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


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

    public static void main(String[] args) {
        BeanA beanA = new BeanA();
        beanA.setNum(1);

        BeanA bean2 = new BeanA();
        bean2.setNum(2);
        BeanA bean3 = new BeanA();
        bean3.setNum(3);
        List<BeanA> list = new ArrayList();
        list.add(beanA);
        list.add(bean2);
        list.add(bean3);
        final BeanA beanA3 = new BeanA();
        list.stream().forEach(beanA1 -> {beanA3.setNum(beanA3.getNum()+beanA1.getNum());});
        System.out.println(beanA3.getNum());
    }
}
