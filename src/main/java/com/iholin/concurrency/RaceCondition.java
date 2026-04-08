package com.iholin.concurrency;

public class RaceCondition {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable increment = () -> {
            for (int i = 0; i < 100_000; i++) {
                counter ++;
            }
        };

        Thread thread1 = new Thread(increment);
        Thread thread2 = new Thread(increment);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Waiting: 200_000");
        System.out.println("Have: " + counter);
    }
}
