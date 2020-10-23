package com.ambity;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

public class ReetLockLearn {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                reentrantLock.lock();
                Thread.sleep(20000);
                reentrantLock.unlock();
            }
        });
        thread.start();
        Thread.sleep(2000);
        reentrantLock.lock();
        Thread.sleep(2000);
        reentrantLock.unlock();
    }
}
