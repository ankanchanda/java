package java_learnings.multithreading.types_lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockConn{

    private static class ReentrantLockConnHelper{
        private static final ReentrantLock INSTANCE_OBJECT = new ReentrantLock();
    }

    public static ReentrantLock getInstance(){
        return ReentrantLockConnHelper.INSTANCE_OBJECT;
    }
}

public class SharedResource {

    boolean isAvailable = false;
    ReentrantLock lock = ReentrantLockConn.getInstance();

    public void producer(){
        try{
            lock.lock(); // lock acquired by the thread, doesn't depend on the object
            System.out.println("Lock acquired by " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        }
        catch(Exception e){

        }
        finally{
            lock.unlock();
            System.out.println("Lock released by " + Thread.currentThread().getName());
        }
    }
}
