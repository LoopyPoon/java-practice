package com.iholin.concurrency;

public class ThreadBasics {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Task 1");
        MyThread thread2 = new MyThread("Task 2");

        thread1.start();
        thread2.start();

        System.out.println("Main thread continued the work");
    }
}
