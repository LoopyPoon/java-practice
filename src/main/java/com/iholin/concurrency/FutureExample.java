package com.iholin.concurrency;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            Thread.sleep(2000);
            return "Data from Database";
        };

        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Data from API";
        };

        Future<String> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);

        System.out.println("Task started, main worked...");

        String result1 = future1.get();
        String result2 = future2.get();

        System.out.println(result1);
        System.out.println(result2);

        executor.shutdown();
    }
}
