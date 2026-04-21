package com.iholin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task2_Executor {
    public static void main(String[] args) throws InterruptedException {

        try(var executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 5; i++) {
                int taskNum = i;
                executorService.submit(() -> {
                    System.out.println("Task: " + taskNum + " started [" + Thread.currentThread() + "]");
                    try {
                        Thread.sleep(1000);
                        System.out.println("Task: " + taskNum + " finished");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
        System.out.println("All Task Finished!");
    }
}
