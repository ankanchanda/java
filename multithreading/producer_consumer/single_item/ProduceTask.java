package java_learnings.multithreading.producer_consumer.single_item;

public class ProduceTask implements Runnable{

    SharedResource sharedResource;

    ProduceTask(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Producer Thread: " + Thread.currentThread().getName());
        try{
            Thread.sleep(5000l);
        }
        catch(Exception e){
            System.out.println("Caught Exception at ProduceTask " + e.getMessage());
        }
        sharedResource.addItem();
    }
    
}
