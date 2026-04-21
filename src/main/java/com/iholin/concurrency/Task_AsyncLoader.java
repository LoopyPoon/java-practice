package com.iholin.concurrency;

import java.util.concurrent.CompletableFuture;

public class Task_AsyncLoader {

    public static CompletableFuture<String> loadUser(String name) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
            return "User: " + name;
        });
    }

    public static CompletableFuture<String> loadOrders(int orderCount) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
            return "Orders: " + orderCount;
        });
    }

    public static CompletableFuture<String> loadBalance(int balance) {
        return CompletableFuture.supplyAsync(() ->{
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
            return "Balance: " + balance + "р";
        });
    }

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        CompletableFuture<String> userFuture = loadUser("Ivan");
        CompletableFuture<String> ordersFuture = loadOrders(5);
        CompletableFuture<String> balanceFuture = loadBalance(1500);


        CompletableFuture<String> pageFuture = CompletableFuture.allOf(userFuture, ordersFuture, balanceFuture).thenApply(v -> {
            return String.format("%s, %s, %s",
                    userFuture.join(),
                    ordersFuture.join(),
                    balanceFuture.join());
        });


        System.out.println(pageFuture.join());
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("Time: " + elapsed + " ms");
    }
}
