package com.multithreads.ZeroEvenOdd;

class ZeroEvenOdd {
    private int n;

    private volatile Integer index = 0;

    private int zero;

    private int odd;

    private int even;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zero = n;
        this.odd = n/2+n%2;
        this.even = n/2;
    }

    // IntConsumer.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {



        for(int i = 0 ;i < this.zero;i++){


            synchronized (this){

                if(index == 0 ){

                    printNumber.accept(0);
                    index = 1;
                    this.notifyAll();


                }else if(index == 2){

                    printNumber.accept(0);
                    index=3;
                    this.notifyAll();

                }else{

                    this.wait();
                    i = i -1;
                }


            }



        }




    }

    public void odd(IntConsumer printNumber) throws InterruptedException {

        for(int i =0 ;i <this.odd;i++) {
            synchronized (this) {

                if (index == 1) {

                    printNumber.accept((i+1) * 2 - 1);
                    index = 2;
                    this.notifyAll();

                } else {
                    this.wait();  //pending
                    i = i - 1;
                }

            }
        }

    }


    public void even(IntConsumer printNumber) throws InterruptedException {


        for(int i =0 ;i <this.even;i++) {
            synchronized (this) {

                if (index == 3) {

                    printNumber.accept((i+1) * 2);
                    index = 0;
                    this.notifyAll();

                } else {
                    this.wait();
                    i = i - 1;
                }

            }
        }

    }


}