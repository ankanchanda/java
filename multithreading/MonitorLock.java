package java_learnings.multithreading;

public class MonitorLock {

    // puts monitor lock on the object obj
    public synchronized void task1(){
        try{
            System.out.println("inside task1");
            Thread.sleep(10000);
            System.out.println("Task1 completed");
        } catch(Exception e){
            System.out.println("Caught Exception " + e.getMessage());
        }
    }

    // here again it wants a lock on the same object
    public void task2(){
        System.out.println("task2, but before synchronised");
        synchronized(this) {
            // thread 2 will wait
            System.out.println("task2, inside synchronised");
        }
    }

    public void task3(){
        System.out.println("inside task3");
    }

    public static void main(String[] args) {
        MonitorLock obj = new MonitorLock();

        Thread thread1 = new Thread(() -> {obj.task1();});
        Thread thread2 = new Thread(() -> {obj.task2();});
        Thread thread3 = new Thread(() -> {obj.task3();});

        thread1.start();
        thread2.start();
        thread3.start();

        // alternative using runnable class
        // MonitorThreadRunnable runnableObj = new MonitorThreadRunnable(obj);
        //  Thread thread1 = new Thread(runnableObj);
    }
}
