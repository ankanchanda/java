package java_learnings.multithreading.producer_consumer.buffer;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(5);

        
        Thread producerThread = new Thread(() -> {
            System.out.println("Producer Thread: " + Thread.currentThread().getName());
            try {
                for(int i=0; i<8; i++){
                    sharedResource.addItem();
                }
            }
            catch(Exception e){
                System.out.println("Caught exception at producer thread " + e.getMessage());
            }
            
        });

        Thread consumerThread = new Thread(() -> {
            System.out.println("Consumer Thread: " + Thread.currentThread().getName());
            try {
                for(int i=0; i<8; i++){
                    sharedResource.consumeItem();
                }
            }
            catch(Exception e){
                System.out.println("Caught exception at consumer thread " + e.getMessage());
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}
