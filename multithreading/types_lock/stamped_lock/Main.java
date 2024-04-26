package java_learnings.multithreading.types_lock.stamped_lock;

public class Main {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        SharedResource resource2 = new SharedResource();
        Thread thread1 = new Thread(() -> {
            resource1.optimisticProducer();
        });

        Thread thread2 = new Thread(() ->{
            try{
                Thread.sleep(500);
                resource2.consume();
            }
            catch(Exception e){

            }
            
        });

        thread1.start();
        thread2.start();
    }   
}
