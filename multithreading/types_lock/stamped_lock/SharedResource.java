package java_learnings.multithreading.types_lock.stamped_lock;

import java.util.concurrent.locks.StampedLock;

class StampedLockInstance{

    private StampedLockInstance(){}

    private static class StampedLockHelper{
        private static final StampedLock INSTANCE_OBJECT = new StampedLock();
    }

    public static StampedLock getInstance(){
        return StampedLockHelper.INSTANCE_OBJECT;
    }
}

public class SharedResource {
    
    private boolean isAvailable = false;
    int a = 10;
    StampedLock lock = StampedLockInstance.getInstance();

    public void producer(){
        long stamp = lock.readLock();
        try{
            System.out.println("Read lock acquired by " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(6000);
        }
        catch(Exception e){

        }
        finally{
            lock.unlockRead(stamp);
            System.out.println("Read lock released by " + Thread.currentThread().getName());
        }
    }

    public void optimisticProducer(){
        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("Taken optimistic read " +  Thread.currentThread().getName());
            System.out.println(a);
            int temp = a;
            a = 11;
            System.out.println(a);

            Thread.sleep(6000);
            if(lock.validate(stamp)){
                System.out.println("updated value successfully");
                System.out.println(a);
            }
            else{
                System.out.println("rollback of work");
                a = temp;
                System.out.println(a);
            }
        }
        catch(Exception e){

        }
    }

    public void consume(){
        long stamp = lock.writeLock();
        try{
            
            System.out.println("Write Lock Acquired by " + Thread.currentThread().getName());
            System.out.println(a);
            isAvailable = false;
            a = 9;
            System.out.println(a);
            Thread.sleep(3000);
        }
        catch(Exception e){

        }
        finally{
            isAvailable = false;
            lock.unlockWrite(stamp);;
            System.out.println("Write Lock released by " + Thread.currentThread().getName());
        }
    }
}