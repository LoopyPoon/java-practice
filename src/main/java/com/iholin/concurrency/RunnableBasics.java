package com.iholin.concurrency;

public class RunnableBasics {
    public static void main(String[] args) {

        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 1 - step " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Task 1 stopped");
                    return;
                }
            }
            System.out.println("Task 1 - Done!");
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Task 2 - step " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("Task 2 stopped");
                    return;
                }
            }
            System.out.println("Task 2 - Done!");
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        System.out.println("Main thread continued the work");
    }
}
