package java_learnings.multithreading;

import java_learnings.multithreading.dead_lock_using_suspend.SharedResources;

public class ThreadPriority {
    public static void main(String[] args) {

        System.out.println("Thread " + Thread.currentThread().getName() + "started");
        SharedResources sharedResources = new SharedResources();

        Thread t1 = new Thread(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " calling produce method");
            sharedResources.produce();
        });

        t1.start();
        t1.setPriority(1); // priority ranges from 1 to 10, low priority  = 1, high priority = 10

        System.out.println("Thread " + Thread.currentThread().getName() + " is finishing its work");
    }
}
