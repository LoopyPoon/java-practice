package com.iholin.concurrency;

public class SynchronizedExample {

    private static int counter = 0;
    private static final Object lock = new Object();

    public static void increment1() {
        synchronized (lock) {
            counter++;
        }
    }

    public static synchronized void increment2() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            for (int i = 0; i < 100_000; i++) {
                increment2();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task1);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Result: " + counter);
    }
}
