package java_learnings.multithreading.real_example;

public class SharedResource {
    boolean itemAvailable = false;

    // synchronised -> put the monitor lock
    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println("Item added by: " + Thread.currentThread().getName() + " and invoking all threads which are waiting");
        notifyAll(); // notify all the threads whoever is waiting on this object will wake up
    }

    public synchronized void consumeItem(){
        System.out.println("consumeItem method invoked by: " + Thread.currentThread().getName());

        // using while loop to avoid "spurious wake-up" sometimes because of system noise
        while (!itemAvailable) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now");
                wait(); // it releases the monitor lock
            }
            catch(Exception e){
                System.out.println("Caught Exception in consumeItem " + e.getMessage());
            }
        }

        System.out.println("Item consumed by: " + Thread.currentThread().getName());
        itemAvailable = false;
    }
}
