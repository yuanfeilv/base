package com.ambity.springbootbase.importtest;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,2,1, TimeUnit.DAYS,new LinkedBlockingDeque<>(),new ThreadPoolExecutor.CallerRunsPolicy());
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1,2,1, TimeUnit.DAYS,new LinkedBlockingDeque<>(),new ThreadPoolExecutor.CallerRunsPolicy());

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            return "ok1";
        },threadPoolExecutor);
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            return "ok2";
        },threadPoolExecutor2);
       CompletableFuture<String> b = completableFuture2.thenCombine(completableFuture,(result1, result2)->{
          return result1 + ":" + result2;
        });
        System.out.println(b.get());
        System.exit(0);
    }
}
