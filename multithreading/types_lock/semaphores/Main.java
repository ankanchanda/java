package java_learnings.multithreading.types_lock.semaphores;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        SharedResource sharedResource = new SharedResource();
        List<Thread> threads = new ArrayList<>();

        for(int i=0; i<4; i++){
            threads.add(
                new Thread(()->{
                    sharedResource.producer();
                })
            );
        }

        for(Thread thread: threads){
            thread.start();
        }
        System.out.println("All threads started");
    }
}
