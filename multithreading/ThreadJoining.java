package java_learnings.multithreading;

import java_learnings.multithreading.dead_lock_using_suspend.SharedResources;

public class ThreadJoining {

    public static void main(String[] args) {

        System.out.println("Thread " + Thread.currentThread().getName() + "started");
        SharedResources sharedResources = new SharedResources();

        Thread t1 = new Thread(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " calling produce method");
            sharedResources.produce();
        });

        t1.start();

        try{
            System.out.println("Thread " + Thread.currentThread().getName() + " will wait for thread 1 to finish it's work");
            t1.join(); // telling main thread to wait till the current thread execution is finished

        }
        catch(Exception e){

        }

        System.out.println("Thread " + Thread.currentThread().getName() + " is finishing its work");
    }
    
}
