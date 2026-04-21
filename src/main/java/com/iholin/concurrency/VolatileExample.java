package com.iholin.concurrency;

public class VolatileExample {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (running) {
                System.out.println("Working");
            }
            System.out.println("Stopped");
        });

        worker.start();
        Thread.sleep(10);
        running = false;

    }
}
