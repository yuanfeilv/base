package com.ambity;

import com.ambity.serivce.MySerivce;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        FileSystemXmlApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("D:\\study\\learn\\springlearn\\src\\main\\resources\\Spring-context.xml");
//        MySerivce mySerivce = (MySerivce) fileSystemXmlApplicationContext.getBean("mySerivce","22");
//        mySerivce.sayHello();
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Myconfig.class);
        MySerivce mySerivce =  annotationConfigApplicationContext.getBean(MySerivce.class);
        mySerivce.sayHello();
    }
}
