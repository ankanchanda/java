package java_learnings.multithreading.condition;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            for(int i=0; i<2; i++){
                resource.produce();
            }
        });

        Thread thread2 = new Thread(() -> {
            for(int i=0; i<2; i++){
                resource.consume();
            }
        });

        thread1.start();
        thread2.start();

    }
}
