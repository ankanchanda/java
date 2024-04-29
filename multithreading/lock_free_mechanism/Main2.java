package java_learnings.multithreading.lock_free_mechanism;

public class Main2 {
    public static void main(String[] args) {
        
        SharedResource resource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            for(int i=0; i<200; i++){
                resource.incrementAtomicCounter();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i=0; i<200; i++){
                resource.incrementAtomicCounter();
            }
        });

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }
        catch(Exception e){

        }

        System.out.println(resource.getAtomicCounter());
    }
}
