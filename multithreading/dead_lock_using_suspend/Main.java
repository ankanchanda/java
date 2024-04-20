package java_learnings.multithreading.dead_lock_using_suspend;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " Thread started");

        SharedResources sharedResources = new SharedResources();
        Thread t1 = new Thread(()->{
            System.out.println("Thread " + Thread.currentThread().getName() + " calling produce method");
            sharedResources.produce();
        });

        Thread t2 = new Thread(()->{
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){

            }
            System.out.println("Thread " + Thread.currentThread().getName() + " calling produce method");
            sharedResources.produce();
        });

        t1.start();
        t2.start();


        try{
            Thread.sleep(3000);
        }
        catch(Exception e){

        }
        System.out.println(t1.getName() + " is suspended");
        t1.suspend();

        // try{
        //     Thread.sleep(3000);
        // }
        // catch(Exception e){

        // }
        // t1.resume();


        System.out.println("Thread " + Thread.currentThread().getName() + " is finishing its work");

    }
}
