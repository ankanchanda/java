package java_learnings.multithreading.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockConn{

    private ReentrantLockConn(){}

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
    Condition condition = lock.newCondition();

    public void produce(){
        try{
            lock.lock(); // lock acquired by the thread, doesn't depend on the object
            System.out.println("Produce Lock acquired by " + Thread.currentThread().getName());
            if(isAvailable){
                System.out.println("Producer thread is waiting: " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            condition.signal();
        }
        catch(Exception e){

        }
        finally{
            lock.unlock();
            System.out.println("Producer Lock released by " + Thread.currentThread().getName());
        }
    }

    public void consume(){
        try{
            Thread.sleep(1000);
            lock.lock(); // lock acquired by the thread, doesn't depend on the object
            System.out.println("Comsume Lock acquired by " + Thread.currentThread().getName());
    
            if(!isAvailable){
                System.out.println("Comsume thread is waiting: " + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = false;
            condition.signal();
        }
        catch(Exception e){

        }
        finally{
            lock.unlock();
            System.out.println("Comsume Lock released by " + Thread.currentThread().getName());
        }
    }
}
