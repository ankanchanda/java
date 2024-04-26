package java_learnings.multithreading.types_lock.read_write;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriteLockInstance {

    private ReadWriteLockInstance(){}

    private static class ReadWriteLockInstanceHelper{
        private static final ReentrantReadWriteLock INSTANCE_OBJECT = new ReentrantReadWriteLock(); 
    }

    public static ReentrantReadWriteLock getInstance(){
        return ReadWriteLockInstanceHelper.INSTANCE_OBJECT;
    }
}

public class SharedResource {

    private boolean isAvailable = false;
    private ReentrantReadWriteLock lock = ReadWriteLockInstance.getInstance();

    public void produce(){
        try{
            lock.readLock().lock();
            System.out.println("Read Lock Acquired by " + Thread.currentThread().getName());
            System.out.println(isAvailable);
            Thread.sleep(8000);
        }
        catch(Exception e){

        }
        finally{
            lock.readLock().unlock();
            System.out.println("Read Lock released by " + Thread.currentThread().getName());
        }
    }

    public void consume(){
        try{
            lock.writeLock().lock();
            System.out.println("Write Lock Acquired by " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(3000);
        }
        catch(Exception e){

        }
        finally{
            isAvailable = false;
            lock.writeLock().unlock();
            System.out.println("Write Lock released by " + Thread.currentThread().getName());
        }
    }
    
}
