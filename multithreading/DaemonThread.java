package java_learnings.multithreading;

import java_learnings.multithreading.dead_lock_using_suspend.SharedResources;

public class DaemonThread {
    public static void main(String[] args) {

        System.out.println("Thread " + Thread.currentThread().getName() + " started");
        SharedResources sharedResources = new SharedResources();

        Thread t1 = new Thread(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " calling produce method");
            sharedResources.produce();
        });
        System.out.println("Thread " + Thread.currentThread().getName() + " is daemon: " + Thread.currentThread().isDaemon());

        t1.setDaemon(true);
        t1.start();

        System.out.println("Thread " + Thread.currentThread().getName() + " is finishing its work");
    }
}
