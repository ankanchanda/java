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