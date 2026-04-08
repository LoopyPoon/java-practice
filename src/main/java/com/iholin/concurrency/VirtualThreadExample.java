package com.iholin.concurrency;

import java.util.concurrent.Executors;

public class VirtualThreadExample {
    public static void main(String[] args) throws InterruptedException {

        Thread platformThread = new Thread(() -> {
            System.out.println("Platform: " + Thread.currentThread());
        });

        Thread virtualThread = Thread.ofVirtual().start(() -> {
            System.out.println("Virtual: " + Thread.currentThread());
        });

        for (int i = 0; i < 1_000_000; i++) {
            Thread.ofVirtual().start(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
            });
        }

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10_000; i++) {
                int taskNum = i;
                executor.submit(() -> {
                    Thread.sleep(1000);
                    return "Result: " + taskNum;
                });
            }
        }
    }
}
