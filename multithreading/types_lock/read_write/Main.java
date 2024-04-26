package java_learnings.multithreading.types_lock.read_write;

public class Main {
    public static void main(String[] args) {
        
        SharedResource resource1 = new SharedResource();
        SharedResource resource2 = new SharedResource();

        Thread thread1 = new Thread(() -> {
            resource1.produce();
        });

        Thread thread2 = new Thread(() -> {
            try{
                Thread.sleep(1000);
                resource1.produce();
            }
            catch(Exception e){

            }
        });

        Thread thread3 = new Thread(() -> {
            try{
                Thread.sleep(2000);
                resource2.consume();
            }
            catch(Exception e){

            }
        });

        Thread thread4 = new Thread(() -> {
            try{
                Thread.sleep(9000);
                resource2.produce();
            }
            catch(Exception e){

            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
