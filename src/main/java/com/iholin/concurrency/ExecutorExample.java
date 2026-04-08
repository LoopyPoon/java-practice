package com.iholin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 1; i <= 10; i++) {
            int taskNum = i;
            executor.submit(() -> {
                System.out.println("Task " + taskNum + " [" + Thread.currentThread().getName() + "]");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            });
        }

        executor.shutdown();

        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("All task complete!");
    }
}
