package com.iholin.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public static void tryIncrement() {
        if (lock.tryLock()) {
            try {
                counter++;
            } finally {
                lock.unlock();
            }
        } else System.out.println("Lock is busy, skipping");
    }
}
