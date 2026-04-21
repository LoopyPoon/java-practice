package com.iholin.concurrency;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Loading... [" + Thread.currentThread().getName() + "]");
            sleep(1000);
            return "Ivan:+79001111111";
        }).thenApply(data -> {
            System.out.println("Processing... [" + Thread.currentThread().getName() + "]");
            return data.toUpperCase();
        }).thenApply(data -> {
            return "Result: " + data;
        });

        System.out.println("Main continue the work...");

        String result = future.get();
        System.out.println(result);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {}
    }
}
