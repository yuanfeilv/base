package com.ambity.jvmlearn.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("runAsync无返回值");
        });

        System.out.println(1);
//        future1.get();
        System.out.println(2);
        //有返回值
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync有返回值");
            return "111";
        });

        System.out.println(3);
        String s = future2.get();
        System.out.println(s);
    }
}
