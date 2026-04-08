package com.iholin.concurrency;

public class MyThread extends Thread {
    private String taskName;

    public MyThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(taskName + " - step " + i + " [" + Thread.currentThread().getName() + "]");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(taskName + " stopped!");
                return;
            }
        }
        System.out.println(taskName + " - DONE!");
    }
}
