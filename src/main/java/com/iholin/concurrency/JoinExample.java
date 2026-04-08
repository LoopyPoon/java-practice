package com.iholin.concurrency;

public class JoinExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Data is loading");
            } catch (InterruptedException e) {
                System.out.println("Thread stopped");
            }
        });

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Data loaded");
    }
}
