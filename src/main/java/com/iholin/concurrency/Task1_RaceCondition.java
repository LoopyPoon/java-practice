package com.iholin.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class Task1_RaceCondition {
    private static int counter = 0;

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 100_000; i++) {
                lock.lock();
                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Result: " + counter);
    }
}
