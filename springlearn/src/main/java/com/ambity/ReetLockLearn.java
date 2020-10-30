package com.ambity;

import lombok.SneakyThrows;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ReetLockLearn {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.MINUTES,new ArrayBlockingQueue<>(1));
        Future<String> future =  threadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "11";
            }
        });
        future.get();
    }
}
