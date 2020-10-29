package com.ambity.serivce;


import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class MySerivce {
    public void sayHello(){
        System.out.println("111");
    }
    public void test1(){
        throw new RuntimeException("111");
    }
    public void test2(){
        test1();
    }
    public void test3(){
        test2();
    }

    public static void main(String[] args) {
        MySerivce mySerivce = new MySerivce();
        try {
            mySerivce.test3();
        }catch (Exception e){
            System.out.println(222);
        }

    }
}
