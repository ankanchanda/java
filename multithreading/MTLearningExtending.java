package java_learnings.multithreading;

public class MTLearningExtending extends Thread{
    @Override
    public void run(){
        System.out.println("code executed by thread: " + Thread.currentThread().getName());
    }
}
