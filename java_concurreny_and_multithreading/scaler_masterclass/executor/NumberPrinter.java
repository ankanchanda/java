package miscellaneous.java_concurreny_and_multithreading.scaler_masterclass.executor;

class NumberPrinter implements Runnable{
    private int numberToPrint;

    NumberPrinter(int x){
        this.numberToPrint = x;
    }

    @Override
    public void run() {
        System.out.println(this.numberToPrint +" : " + Thread.currentThread().getName());

    }

    


}