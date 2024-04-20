package java_learnings.multithreading.dead_lock_using_suspend;

public class SharedResources {
    
    private boolean isAvailable = false;
    public synchronized void produce(){

        isAvailable = true;
        System.out.println("Lock Aquired by " + Thread.currentThread().getName());

        try{
            Thread.sleep(8000);
        }
        catch(Exception e){

        }
        System.out.println("Lock Released by " + Thread.currentThread().getName());
    }
}
