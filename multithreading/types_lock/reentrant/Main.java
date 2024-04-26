package java_learnings.multithreading.types_lock.reentrant;

public class Main {
    public static void main(String[] args) {

        SharedResource resource1 = new SharedResource();
        Thread thread1 = new Thread(()->{
            resource1.producer();
        });

        SharedResource resource2 = new SharedResource();
        Thread thread2 = new Thread(()->{
            resource2.producer();
        });

        thread1.start();
        thread2.start();

    }
}
