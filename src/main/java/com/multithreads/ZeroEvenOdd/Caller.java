package com.multithreads.ZeroEvenOdd;

public class Caller {


    public static void main(String[] args) {

        ZeroEvenOdd zeo = new ZeroEvenOdd(10);


        new Thread(
            ()->{try{zeo.zero(new IntConsumer());}catch (Exception e){e.printStackTrace();}}
        ,"zero").start();

        new Thread(
                ()->{try{zeo.odd(new IntConsumer());}catch (Exception e){e.printStackTrace();}}
        ,"odd").start();

        new Thread(
                ()->{try{zeo.even(new IntConsumer());}catch (Exception e){e.printStackTrace();}}
        ,"even").start();


    }

}
