package com.ambity.springbootbase.exector;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyExector {

    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,5, TimeUnit.HOURS,new ArrayBlockingQueue<Runnable>(5));
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("条件等待状态");
                try {
                    lock.lock();
                    condition.await();
                    System.out.println("条件等待结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        thread.start();
        lock.lock();
        System.out.println("我获取到了锁");
        condition.signal();
        lock.unlock();

    }
}
