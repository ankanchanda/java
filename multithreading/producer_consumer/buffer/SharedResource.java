package java_learnings.multithreading.producer_consumer.buffer;
import java.util.Queue;
import java.util.LinkedList;

public class SharedResource {
    
    Queue<Integer> queue;
    int bufferSize;
    int item;

    SharedResource(int bufferSize){
        queue = new LinkedList<>();
        this.bufferSize = bufferSize;
        item = 1;
    }

    public synchronized void addItem(){
        System.out.println("addItem invoked by " + Thread.currentThread().getName());

        System.out.println("Queue size: " + queue.size());
        while(queue.size()>=bufferSize){
            try{
                System.out.println("Queue is full " +  Thread.currentThread().getName() +" is waiting now");
                wait();
            }
            catch(Exception e){
                System.out.println("Caught Exception while adding item " + e.getMessage());
            }
        }

        queue.add(item);
        System.out.println("Item " + item + " added to queue by " + Thread.currentThread().getName());
        System.out.println("addItem > Notifying all the threads waiting");
        item += 1;
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("consumeItem invoked by " + Thread.currentThread().getName());

        while(queue.isEmpty()){
            try{
                System.out.println("Queue is empty " +  Thread.currentThread().getName() +" is waiting now.");
                wait();
            }
            catch(Exception e){
                System.out.println("Caught Exception while consuming item " + e.getMessage());
            }
        }

        int consumedItem = queue.poll();
        System.out.println("Item " + consumedItem + " consumed by " + Thread.currentThread().getName());
        System.out.println("consumeItem > Notifying all the threads waiting");
        notifyAll();
    }

}
