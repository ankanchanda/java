package java_learnings.multithreading.real_example;

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
