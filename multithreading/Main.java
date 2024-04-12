package java_learnings.multithreading;

public class Main {
    public static void main(String[] args) {

        // Using runnable interface
        System.out.println("Going inside main method: "+ Thread.currentThread().getName());
        MTLearning runnableObj = new MTLearning();

        Thread thread = new Thread(runnableObj);
        thread.start();

        System.out.println("Finish the main method: " + Thread.currentThread().getName());

        // extending the Thread class
        System.out.println("Going inside main method: "+ Thread.currentThread().getName());

        MTLearningExtending myThread = new MTLearningExtending();
        myThread.start();

        System.out.println("Finish the main method: " + Thread.currentThread().getName());
    }
}