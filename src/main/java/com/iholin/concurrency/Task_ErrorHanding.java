package com.iholin.concurrency;

import java.util.concurrent.CompletableFuture;

public class Task_ErrorHanding {

    public static CompletableFuture<String> loadData() {
        return CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Server is unavailable!");
        });
    }

    public static void main(String[] args) {
        CompletableFuture<String> dataFuture = loadData()
                .exceptionally(ex -> {
                    System.out.println("Log error: " + ex.getMessage());
                    return "Data from cache";
                })
                .thenApply(String::toUpperCase);

        System.out.println(dataFuture.join());
    }

}
