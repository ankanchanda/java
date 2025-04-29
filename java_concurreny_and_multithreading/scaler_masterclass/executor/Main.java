package miscellaneous.java_concurreny_and_multithreading.scaler_masterclass.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 1; i<=100; i++){
            if(i==5 || i==10 || i==95){
                System.out.println("DEBUG");
            }
            NumberPrinter numberPrinter =  new NumberPrinter(i);
            executorService.execute(numberPrinter);
        }
        executorService.shutdown();
    }
}
