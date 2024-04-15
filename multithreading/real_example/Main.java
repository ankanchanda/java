package java_learnings.multithreading.real_example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main method start");

        SharedResource sharedResource = new SharedResource();

        ProduceTask produceTaskRunnable = new ProduceTask(sharedResource);
        ConsumeTask consumerTaskRunnable = new ConsumeTask(sharedResource);

        // producer thread
        Thread producerThread = new Thread(produceTaskRunnable);

        // consumer thread
        Thread consumerThread = new Thread(consumerTaskRunnable);

        // thread is in runnable state
        producerThread.start();
        consumerThread.start();

        System.out.println("Main method end");

    }
}
