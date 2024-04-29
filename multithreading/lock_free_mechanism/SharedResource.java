package java_learnings.multithreading.lock_free_mechanism;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {
    
    int counter = 0;
    AtomicInteger atomicCounter = new AtomicInteger(0);

    void increment(){
        counter++; // not atomic
    }

    int get(){
        return counter;
    }

    void incrementAtomicCounter(){
        atomicCounter.incrementAndGet();
    }

    int getAtomicCounter(){
        return atomicCounter.get();
    }
}
