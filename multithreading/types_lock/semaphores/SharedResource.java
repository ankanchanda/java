package java_learnings.multithreading.types_lock.semaphores;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.StampedLock;

class SemaphoreInstance{

    private SemaphoreInstance(){}

    private static class SemaphoreHelper{
        private static final Semaphore INSTANCE_OBJECT = new Semaphore(2);
    }

    public static Semaphore getInstance(){
        return SemaphoreHelper.INSTANCE_OBJECT;
    }
}

public class SharedResource {

    private boolean isAvailable = false;
    Semaphore lock = SemaphoreInstance.getInstance();

    public void producer(){
        
        try{
            lock.acquire();
            System.out.println("Lock acquired by " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        }
        catch(Exception e){

        }
        finally{
            System.out.println("Lock released by " + Thread.currentThread().getName());
            lock.release();
        }
    }
}
