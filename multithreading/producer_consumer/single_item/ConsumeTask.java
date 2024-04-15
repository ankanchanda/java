package java_learnings.multithreading.producer_consumer.single_item;

public class ConsumeTask implements Runnable{

    SharedResource sharedResource;

    ConsumeTask(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Consumer Thread: " + Thread.currentThread().getName());
        sharedResource.consumeItem();
    }
    
}
