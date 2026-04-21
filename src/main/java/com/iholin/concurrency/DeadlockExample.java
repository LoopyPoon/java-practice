package com.iholin.concurrency;

public class DeadlockExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1 take lock 1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                synchronized (lock2) {
                    System.out.println("Thread 1 take lock 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2 take lock 2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                synchronized (lock1) {
                    System.out.println("Thread 2 take lock 1");
                }
            }
        });

        thread1.start();
        thread2.start();


    }
}
