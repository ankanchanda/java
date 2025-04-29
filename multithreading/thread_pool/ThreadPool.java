package java_learnings.multithreading.thread_pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {
        // ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectHandler());
        executor.allowCoreThreadTimeOut(true);
        for(int i=0; i<7; i++){
            executor.submit(() -> {
                try{
                    Thread.sleep(5000);
                }
                catch(Exception e){

                }
                System.out.println("Task Processed by thread " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory{


    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        return thread;
    }
    
}

class CustomRejectHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task rejected " + r.toString());
    }
    
}