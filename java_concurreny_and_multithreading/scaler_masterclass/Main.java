public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World: "+ Thread.currentThread().getName());
        // HelloWorldPrinter hwp =  new HelloWorldPrinter();
        // Thread thread1 = new Thread(hwp);
        // Thread thread2 = new Thread(hwp);
        // Thread thread3 = new Thread(hwp);
        // thread1.start();
        // thread2.start();
        // thread3.start();

        for(int i = 1; i <= 100; i++){
            NumberPrinter np = new NumberPrinter(i);
            Thread t =  new Thread(np);
            t.start();
        }
        
    }
}
